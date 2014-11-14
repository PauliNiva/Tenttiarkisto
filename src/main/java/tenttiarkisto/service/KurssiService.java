package tenttiarkisto.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @Transactional
    public Kurssi addKurssi(String nimi) {
        return kurssiRepo.save(new Kurssi(nimi));
    }

    public List<Kurssi> list() {
        return kurssiRepo.findAll(new Sort(Sort.Direction.ASC, "nimi"));
                
    }

    public Kurssi get(Long id) {
        return kurssiRepo.findOne(id);
    }

    public Kurssi findByName(String name) {
        List<Kurssi> result = kurssiRepo.findByNimi(name);
        if (!result.isEmpty()) {
            return kurssiRepo.findByNimi(name).get(0);
        } else {
            return null;
        }
    }
}
