
package tenttiarkisto.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.profiles.DevProfile;

@Service
public class CSVService {

    public List<Kurssi> readCSV() {

        File file = new File("kurssit.csv");
        List<Kurssi> lista = new ArrayList<>();

        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                String[] rivi = line.split(cvsSplitBy);
                lista.add(new Kurssi(rivi[1], rivi[0]));
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(DevProfile.class).error(e.getMessage());

        } catch (IOException e) {
            Logger.getLogger(DevProfile.class).error(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    Logger.getLogger(DevProfile.class).error(e.getMessage());
                }
            }
        }
        return lista;
    }
}
