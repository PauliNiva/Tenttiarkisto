package tenttiarkisto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tenttiarkisto.domain.Kommentti;
import tenttiarkisto.repo.KieliRepo;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.KommenttiService;
import tenttiarkisto.service.KurssiService;
import tenttiarkisto.service.TenttiService;

@Controller
@RequestMapping(value = "/kommentit")
public class KommenttiController {

    @Autowired
    KommenttiService kommenttiService;

    @Autowired
    TenttiService tenttiService;

    @Autowired
    KurssiService kurssiService;

    @Autowired
    TyyppiRepo tyyppiRepo;

    @Autowired
    KieliRepo kieliRepo;
//
//    @ModelAttribute("kommentti")
//    private Kommentti getKommentti() {
//        return new Kommentti();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String listaaKommentit(Model model) {
        model.addAttribute("kommentit", kommenttiService.list());

        //lomakkeelle
        model.addAttribute("kurssit", kurssiService.list());
        model.addAttribute("tyypit", tyyppiRepo.findAll());
        model.addAttribute("kielet", kieliRepo.findAll());
        return "/WEB-INF/views/tentin-tiedot.jsp";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String naytaKommentti(Model model, @PathVariable Long id) {
        model.addAttribute("kommentti", kommenttiService.getKommentti(id));
        return "/WEB-INF/views/tentin-tiedot.jsp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addKommentti(Model model,
            @RequestParam("nimi") String nimi,
            @RequestParam("kommentti") String kommentti) {

        Kommentti k = new Kommentti();
        k.setKirjoittaja(nimi);
        k.setSisalto(kommentti);
        kommenttiService.addKommentti(k);

        return "redirect:/kommentit";
    }
}
