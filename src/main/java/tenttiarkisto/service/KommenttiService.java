
package tenttiarkisto.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kommentti;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.repo.KommenttiRepo;
import tenttiarkisto.repo.TenttiRepo;

@Service
public class KommenttiService {
    
    @Autowired
    private KommenttiRepo kommenttiRepo;
    
    @Autowired
    private TenttiRepo tenttiRepo;
    
    @Transactional
    public void addKommentti(Kommentti kommentti){
        kommenttiRepo.save(kommentti);
        kommentti.setPvm(new Date());
        Tentti tentti = kommentti.getKommentoituTentti();
        tentti.getTentinKommentit().add(kommentti);
        
        kommenttiRepo.save(kommentti);
    }
    
    @Transactional
    public void removeKommentti(Long kommenttiId){
        Kommentti kommentti = kommenttiRepo.findOne(kommenttiId);
        Long tentinId = kommentti.getKommentoituTentti().getId();
        tenttiRepo.findOne(tentinId).getTentinKommentit().remove(kommentti);
        kommenttiRepo.delete(kommenttiId);
    }    
}