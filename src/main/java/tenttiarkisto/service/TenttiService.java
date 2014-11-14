package tenttiarkisto.service;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.repo.KurssiRepo;
import tenttiarkisto.repo.TenttiRepo;

@Service
public class TenttiService {

    @Autowired
    private TenttiRepo tenttiRepo;
    @Autowired
    private KurssiRepo kurssiRepo;
    @Autowired
    private FileService fileService;

    public List<Tentti> list() {
        return tenttiRepo.findAll();
    }

    public Tentti get(Long id) {
        return tenttiRepo.findOne(id);
    }

    @Transactional
    public void removeTentti(Long tenttiId) {
        Tentti tentti = tenttiRepo.findOne(tenttiId);
        tentti.getKurssi().getKurssinTentit().remove(tentti);
        tenttiRepo.delete(tentti);
    }

    @Transactional
    public void addTentti(Tentti tentti, File tenttiFile) {
        Kurssi kurssi = tentti.getKurssi();
        kurssi.getKurssinTentit().add(tentti);

        if (tenttiFile != null) {
            tenttiFile.renameTo(new File(tenttiFile.getPath() + makeFilename(tentti)));

            String url = fileService.putFile(tenttiFile);

            tentti.setFileURL(url);
        } else {
            tentti.setFileURL("invalid");
        }

        tenttiRepo.save(tentti);
        kurssiRepo.save(kurssi);
    }

    @Transactional
    public Long addTentti(Tentti tentti, InputStream is, long length, String ext) {
        Kurssi kurssi = tentti.getKurssi();
        kurssi.getKurssinTentit().add(tentti);

        String fileName = makeFilename(tentti) + '.' + ext;

        String url = fileService.putFile(fileName, is, length);

        tentti.setFileURL(url);

        Long id = tenttiRepo.save(tentti).getId();
        kurssiRepo.save(kurssi);
        return id;
    }

    private static String makeFilename(Tentti tentti) {
        StringBuilder filename = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        filename.append(sdf.format(tentti.getPvm()));
        filename.append("-").append(tentti.getKurssi().getNimi().replaceAll("\\s", "_"));
        filename.append("-").append(tentti.getKieli());

        return filename.toString();
    }
}
