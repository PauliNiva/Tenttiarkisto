package tenttiarkisto;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.repo.KurssiRepo;
import tenttiarkisto.service.KurssiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class KurssiServiceTest {

    @Autowired
    private KurssiService kurssiService;
    
    @Autowired
    private KurssiRepo kurssiRepo;

    public KurssiServiceTest() {
    }

    @Test
    public void lisattyKurssiLoytyy() {
        Kurssi kurssi = kurssiService.addKurssi("Ohpe");

        Kurssi haettuKurssi = kurssiService.get(kurssi.getId());
        assertNotNull(haettuKurssi);
        assertEquals(kurssi, haettuKurssi);
        
    }

    @Test
    public void poistettuaKurssiaEiLoydy() {
        Kurssi kurssi = new Kurssi();
        kurssi.setNimi("Ohja");
        kurssiRepo.save(kurssi);
        kurssiService.removeKurssi(kurssi.getId());

        Kurssi haettuKurssi = kurssiService.get(kurssi.getId());
        assertNull(haettuKurssi);
    }

    @Test
    public void lisattyKurssiLoytyyNimella() {
        Kurssi kurssi = new Kurssi();
        kurssi.setNimi("Tito");
        kurssiRepo.save(kurssi);
        
        Kurssi haettuKurssi = kurssiService.findByName("Tito");
        assertEquals(kurssi, haettuKurssi);
    }

    @Test
    public void vainLisatytKurssitLoytyyNimella(){
        Kurssi haettuKurssi = kurssiService.findByName("Wepa");
        assertNull(haettuKurssi);
        
        Kurssi kurssi = new Kurssi();
        kurssi.setNimi("Wepa");
        kurssiRepo.save(kurssi);
        
        haettuKurssi = kurssiService.findByName("Wepa");
        assertNotNull(haettuKurssi);
        assertEquals(kurssi, haettuKurssi);
    }
}
