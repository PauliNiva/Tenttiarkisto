package tenttiarkisto.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kieli;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.KieliRepo;
import tenttiarkisto.repo.TyyppiRepo;

@Service
public class CSVService {

    @Autowired
    KieliRepo kieliRepo;

    @Autowired
    TyyppiRepo tyyppiRepo;

    @Autowired
    KurssiService kurssiService;

    @Autowired
    TenttiService tenttiService;

    public List<Kurssi> readKurssit() {
        Logger log = Logger.getLogger(CSVService.class);

        File file = new File("kurssit.csv");
        List<Kurssi> lista = new ArrayList<>();

        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {

                String[] rivi = line.split(cvsSplitBy);
                lista.add(new Kurssi(rivi[1], rivi[0]));
                log.warn(rivi[1] + " - " + rivi[0]);
                log.warn(new Kurssi(rivi[1], rivi[0]));
            }

        } catch (FileNotFoundException e) {
            log.error(e.getMessage());

        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return lista;
    }

    public void loadTentit(boolean upload) {
        Logger log = Logger.getLogger(CSVService.class);

        File csvFile = new File("tentit.txt");

        BufferedReader br = null;
        String line;
        String split1 = "/";
        String split2 = "_";

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                log.info("Line:\t" + line);

                String[] rivi = line.split(split1);

                String kurssiNimi = rivi[0];
                String[] tenttiRivi = rivi[1].split("\\.")[0].split(split2);
                log.info("Tenttirivi:\t" + Arrays.toString(tenttiRivi));

                Kurssi kurssi = kurssiService.findByName(kurssiNimi);
                if (kurssi == null) {
                    log.error("Kurssi not found: " + kurssiNimi);
                } else {
                    log.info("Kurssi:\t" + kurssi.getNimi());
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
                Date date = sdf.parse(tenttiRivi[0]);
                log.info("Date:\t" + date);

                String pitaja = tenttiRivi[1];
                log.info("Pitaja:\t" + pitaja);

                Tyyppi tyyppi = tyyppiRepo.findByLyhenneIgnoreCase(tenttiRivi[2]);
                log.info("tyyppi:\t" + tyyppi);
                Kieli kieli = kieliRepo.findByLyhenneIgnoreCase(tenttiRivi[3]).get(0);
                log.info("kieli:\t" + kieli);

                Tentti tentti = new Tentti(date, pitaja, kurssi, tyyppi, kieli, null);
                if (upload) {
                    File file = new File("files/" + line);

                    String ext = line.substring(line.lastIndexOf('.') + 1);
                    log.info("ext: " + ext);

                    tenttiService.addTentti(tentti, file, ext);
                }
                else {
                    tenttiService.addTentti(tentti);
                }

            }

        } catch (IOException | ParseException e) {
            log.error(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }
}
