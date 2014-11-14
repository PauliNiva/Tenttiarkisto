package tenttiarkisto.profiles;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.KurssiService;
import tenttiarkisto.service.TenttiService;

@Configuration
@Profile(value = {"dev", "default"})
public class DevProfile {

    @Autowired
    KurssiService kurssiService;

    @Autowired
    TenttiService tenttiService;

    @Autowired
    TyyppiRepo tyyppiRepo;

    @PostConstruct
    @Transactional
    public void init() {
        Tyyppi ek = new Tyyppi();
        ek.setTyyppi("EK");
        tyyppiRepo.save(ek);

        Kurssi k1 = new Kurssi("Tietorakenteet");
        kurssiService.addKurssi(k1);

        tenttiService.addTentti(new Tentti(new Date(114, 4, 24), null, k1, ek, "FI", null), null);
        tenttiService.addTentti(new Tentti(new Date(113, 4, 24), null, k1, ek, "FI", null), null);
        tenttiService.addTentti(new Tentti(new Date(112, 4, 24), null, k1, ek, "FI", null), null);

        Kurssi k2 = new Kurssi("Ohjelmoinnin perusteet");
        kurssiService.addKurssi(k2);
        tenttiService.addTentti(new Tentti(new Date(114, 10, 24), null, k2, ek, "FI", null), null);
        tenttiService.addTentti(new Tentti(new Date(113, 10, 22), null, k2, ek, "FI", null), null);
        tenttiService.addTentti(new Tentti(new Date(112, 10, 20), null, k2, ek, "FI", null), null);

        kurssiService.addKurssi(new Kurssi("Web-palvelinohjelmointi"));
        kurssiService.addKurssi(new Kurssi("Käyttöjärjestelmät"));
        kurssiService.addKurssi(new Kurssi("Johdatus tekoälyyn"));
        kurssiService.addKurssi(new Kurssi("Ohjelmistotuotanto"));
    }

}