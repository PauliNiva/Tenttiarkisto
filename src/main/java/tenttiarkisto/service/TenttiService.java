package tenttiarkisto.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.repo.TenttiRepo;

@Service
public class TenttiService {

    @Autowired
    private TenttiRepo tenttiRepo;
    @Autowired
    private FileService fileService;
    
    public List<Tentti> list() {        
        return tenttiRepo.findAll();        
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

        tenttiFile.renameTo(new File(tenttiFile.getPath() + makeFilename(tentti)));

        String url = fileService.putFile(tenttiFile);

        tentti.setFileURL(url);
        tenttiRepo.save(tentti);
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
