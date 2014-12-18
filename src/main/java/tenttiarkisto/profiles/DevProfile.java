package tenttiarkisto.profiles;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tenttiarkisto.domain.Kieli;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Person;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.KieliRepo;
import tenttiarkisto.repo.PersonRepo;
import tenttiarkisto.repo.KommenttiRepo;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.CSVService;
import tenttiarkisto.service.KommenttiService;
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

    @Autowired
    KieliRepo kieliRepo;

    @Autowired
    CSVService csvService;

    @Autowired
    PersonRepo personRepo;

    @Autowired
    KommenttiService kommenttiService;

    @Autowired
    KommenttiRepo kommenttiRepo;

    @PostConstruct
    @Transactional
    public void init() {
        Logger log = Logger.getLogger(DevProfile.class);

        for (Kurssi kurssi : csvService.readKurssit()) {
            kurssiService.addKurssi(kurssi);
        }

        Tyyppi kk = new Tyyppi();
        kk.setTyyppi("Kurssikoe");
        kk.setLyhenne("KK");
        tyyppiRepo.save(kk);

        Tyyppi ek = new Tyyppi();
        ek.setTyyppi("Erilliskoe");
        ek.setLyhenne("EK");
        tyyppiRepo.save(ek);

        Tyyppi vk1 = new Tyyppi();
        vk1.setTyyppi("1. välikoe");
        vk1.setLyhenne("VK1");
        tyyppiRepo.save(vk1);

        Tyyppi vk2 = new Tyyppi();
        vk2.setTyyppi("2. välikoe");
        vk2.setLyhenne("VK2");
        tyyppiRepo.save(vk2);

        Kieli fi = new Kieli();
        fi.setNimi("Suomi");
        fi.setLyhenne("FI");
        kieliRepo.save(fi);

        Kieli en = new Kieli();
        en.setNimi("English");
        en.setLyhenne("EN");
        kieliRepo.save(en);

        Person admin = new Person();
        admin.setName("pauli");
        admin.setPassword("0000");
        admin.setUsername("admin");
        personRepo.save(admin);
        
        csvService.loadTentit(false);

        Kurssi k1 = kurssiService.findByName("Tietorakenteet ja algoritmit");
        log.info(k1);
//        Kommentti kommentti = new Kommentti();
//        kommentti.setKirjoittaja("Olli Opiskelija");
//        kommentti.setSisalto("Helppo tentti!");
//        kommentti.setKommentoituTentti(k1.getKurssinTentit().get(1));
//        k1.getKurssinTentit().get(1).getTentinKommentit().add(kommentti);
//        Logger log = Logger.getLogger(DevProfile.class);
//        log.warn("haettu tentti:" + kommentti.getKommentoituTentti());
//        log.warn(kommentti.getKommentoituTentti().getTentinKommentit());
//        kommenttiService.addKommentti(kommentti);

    }
}
