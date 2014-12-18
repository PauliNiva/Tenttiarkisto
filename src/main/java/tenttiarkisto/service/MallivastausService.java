package tenttiarkisto.service;

import java.io.InputStream;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Mallivastaus;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.repo.MallivastausRepo;
import tenttiarkisto.repo.TenttiRepo;

@Service
public class MallivastausService {
    
    @Autowired
    private TenttiRepo tenttiRepo;
    
    @Autowired
    private MallivastausRepo mallivastausRepo;
    
    @Autowired
    private FileService fileService;
    
    public List<Mallivastaus> list() {
        return mallivastausRepo.findAll();
    }
    
    public Mallivastaus get(Long id) {
        return mallivastausRepo.findOne(id);
    }
    
    @Transactional
    public void removeMallivastaus(Long mallivastausId) {
        Mallivastaus mallivastaus = mallivastausRepo.findOne(mallivastausId);
        mallivastaus.getTentti().getTentinMallivastaukset().remove(mallivastaus);
        mallivastausRepo.delete(mallivastaus);
    }
    
    @Transactional
    public void addMallivastaus(Mallivastaus mallivastaus) {
        Tentti tentti = mallivastaus.getTentti();
        tentti.getTentinMallivastaukset().add(mallivastaus);
        mallivastaus.setFileURL("https://s3-eu-west-1.amazonaws.com/tentit/" + makeFilename(mallivastaus, "pdf"));
        mallivastausRepo.save(mallivastaus);
        tenttiRepo.save(tentti);
    }
    
    private static String makeFilename(Mallivastaus mallivastaus, String ext) {
        StringBuilder filename = new StringBuilder();
        filename.append(".").append(ext);
        return filename.toString();
    }
    
    @Transactional
    public Long addMallivastaus(Mallivastaus mallivastaus, InputStream is, long length, String ext) {
        Tentti tentti = mallivastaus.getTentti();
        tentti.getTentinMallivastaukset().add(mallivastaus);
        String fileName = makeFilename(mallivastaus, ext);
        String url = fileService.putFile(fileName, is, length);
        tentti.setFileURL(url);
        Long id = mallivastausRepo.save(mallivastaus).getId();
        tenttiRepo.save(tentti);
        return id;
    }
}
