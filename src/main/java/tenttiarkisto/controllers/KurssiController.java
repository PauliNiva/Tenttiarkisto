package tenttiarkisto.controllers;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.KurssiService;
import tenttiarkisto.service.TenttiService;

@Controller
@RequestMapping(value = "kurssit")
public class KurssiController {

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

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("kurssit", kurssiService.list());
        model.addAttribute("tyypit", tyyppiRepo.findAll());
        return "/WEB-INF/views/index.jsp";
    }
}
