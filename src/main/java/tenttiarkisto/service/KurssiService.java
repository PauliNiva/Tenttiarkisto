
package tenttiarkisto.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.repo.KurssiRepo;

@Service
public class KurssiService {
    @Autowired
    private KurssiRepo kurssiRepo;
    
    @Transactional
    public void removeKurssi(Long kurssiId) {
        kurssiRepo.delete(kurssiId);
    }
    
    @Transactional
    public void addKurssi(Kurssi kurssi) {
        kurssiRepo.save(kurssi);        
    }
    
    public List<Kurssi> list() {
        return kurssiRepo.findAll();
    }
    
    public Kurssi get(Long id) {
        return kurssiRepo.findOne(id);
    }
}
