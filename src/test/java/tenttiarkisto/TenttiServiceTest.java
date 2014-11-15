
package tenttiarkisto;


import java.io.File;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.repo.KurssiRepo;
import tenttiarkisto.repo.TenttiRepo;
import tenttiarkisto.service.FileService;
import tenttiarkisto.service.TenttiService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TenttiServiceTest {
    
    @Autowired
    private TenttiService tenttiService;
    
    @Autowired
    private FileService fileService;
    
    @Autowired
    private TenttiRepo tenttiRepo;
    
    @Autowired
    private KurssiRepo kurssiRepo;
    
    public TenttiServiceTest() {
    }
    
    @Test
    public void testAddTentti(){
    }

    
}
