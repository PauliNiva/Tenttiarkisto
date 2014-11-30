
package tenttiarkisto.service;

import java.util.List;
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
    
    public Kommentti getKommentti(Long id){
        return kommenttiRepo.getOne(id);
    }
    public void addKommentti(Kommentti kommentti){
//        Tentti tentti = kommentti.getKommentoituTentti();
//        tentti.getTentinKommentit().add(kommentti);
//        tenttiRepo.save(tentti);
        
        kommenttiRepo.save(kommentti);
    }
    
    public void removeKommentti(Long kommenttiId){
        kommenttiRepo.delete(kommenttiId);
    }
    
    public List<Kommentti> list(){
        return kommenttiRepo.findAll();
    }
    
    
}
