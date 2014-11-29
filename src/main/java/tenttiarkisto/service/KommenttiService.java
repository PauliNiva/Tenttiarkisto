
package tenttiarkisto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tenttiarkisto.domain.Kommentti;
import tenttiarkisto.repo.KommenttiRepo;

@Service
public class KommenttiService {
    
    @Autowired
    private KommenttiRepo kommenttiRepo;
    
    public Kommentti getKommentti(Long id){
        return kommenttiRepo.getOne(id);
    }
    public void addKommentti(Kommentti kommentti){
        kommenttiRepo.save(kommentti);
    }
    
    public void removeKommentti(Long kommenttiId){
        kommenttiRepo.delete(kommenttiId);
    }
    
    public List<Kommentti> list(){
        return kommenttiRepo.findAll();
    }
    
    
}
