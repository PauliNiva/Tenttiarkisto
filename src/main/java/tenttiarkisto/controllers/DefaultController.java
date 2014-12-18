package tenttiarkisto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tenttiarkisto.domain.Kieli;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.KieliRepo;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.CSVService;
import tenttiarkisto.service.KurssiService;

@Controller
public class DefaultController {

    @Autowired
    KurssiService kurssiService;

    @Autowired
    TyyppiRepo tyyppiRepo;

    @Autowired
    KieliRepo kieliRepo;

    @Autowired
    CSVService csvService;

    @RequestMapping("/")
    public String view() {
        return "redirect:/kurssit";
    }

    @RequestMapping(value = "/kirjaudu", method = RequestMethod.GET)
    public String kirjautumisNakyma() {
        return "/WEB-INF/views/kirjaudu.jsp";
    }
   
//    @RequestMapping("/initializekurssit")
//    @ResponseBody
//    public String init() {
//        for (Kurssi kurssi : csvService.readCSV()) {
//            kurssiService.addKurssi(kurssi);
//        }
//
//        Tyyppi kk = new Tyyppi();
//        kk.setTyyppi("Kurssikoe");
//        tyyppiRepo.save(kk);
//
//        Tyyppi ek = new Tyyppi();
//        ek.setTyyppi("Erilliskoe");
//        tyyppiRepo.save(ek);
//
//        Kieli fi = new Kieli();
//        fi.setNimi("Suomi");
//        kieliRepo.save(fi);
//
//        Kieli en = new Kieli();
//        en.setNimi("English");
//        kieliRepo.save(en);
//
//        return "Done";
//    }
}
