
package tenttiarkisto;


import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tenttiarkisto.domain.Kieli;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.KieliRepo;
import tenttiarkisto.repo.KurssiRepo;
import tenttiarkisto.repo.TenttiRepo;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.FileService;
import tenttiarkisto.service.KurssiService;
import tenttiarkisto.service.TenttiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TenttiServiceTest {
    
    @Autowired
    private KurssiService kurssiService;
    
    @Autowired
    private TenttiService tenttiService;
    
    @Autowired
    private FileService fileService;
    
    @Autowired
    private TenttiRepo tenttiRepo;
    
    @Autowired
    private KurssiRepo kurssiRepo;
    
    @Autowired
    private TyyppiRepo tyyppiRepo;
    
    @Autowired
    private KieliRepo kieliRepo;
    
    public TenttiServiceTest() {
    }
    
//    @After
//    public void cleanUp(){
//        kieliRepo.deleteAll();
//        tyyppiRepo.deleteAll();
//        kurssiRepo.deleteAll();
//        tenttiRepo.deleteAll();
//    }
    
//    public Tentti apuLuoTentti(){
//                
//        Tyyppi kk = new Tyyppi();
//        kk.setTyyppi("Kurssikoe");
//        tyyppiRepo.save(kk);
//        
//        Kieli fi = new Kieli();
//        fi.setNimi("FI");
//        kieliRepo.save(fi);
//
//        Kurssi kurssi = new Kurssi();
//        kurssi.setNimi("Wepa");
//        kurssi.setKoodi("1234");
//        kurssiRepo.save(kurssi);
//        
//        Tentti tentti = new Tentti(new Date(2012, 12, 12), "Wikla", kurssi, kk, fi, "url");
//        
//        return tentti; 
//    }
    
//    @Test
//    public void lisattyTenttiLoytyyReposta(){
//        Tentti tentti = apuLuoTentti();
//        tenttiRepo.save(tentti);
//        
//        Tentti haettuTentti = tenttiRepo.findOne(tentti.getId());
//        assertNotNull(haettuTentti);
//        assertEquals(tentti, haettuTentti);
//        
//    }

    
}
