package tenttiarkisto.controllers;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.service.KurssiService;

@Controller
@RequestMapping("/kurssit")
public class KurssiController {
    
    @Autowired
    KurssiService kurssiService;
    
    @PostConstruct
    public void init() {
        kurssiService.addKurssi(new Kurssi("Tietorakenteet"));
        kurssiService.addKurssi(new Kurssi("Ohjelmoinnin perusteet"));
        kurssiService.addKurssi(new Kurssi("Web-palvelinohjelmointi"));
        kurssiService.addKurssi(new Kurssi("Käyttöjärjestelmät"));
        kurssiService.addKurssi(new Kurssi("Johdatus tekoälyyn"));
        kurssiService.addKurssi(new Kurssi("Ohjelmistotuotanto"));
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("kurssit", kurssiService.list());
        return "WEB-INF/views/index.jsp";
    }
    
    @RequestMapping(value = "/{kurssiId}", method= RequestMethod.GET)
    public String show(Model model, @PathVariable Long kurssiId) {
        model.addAttribute("kurssi", kurssiService.get(kurssiId));
        return "WEB-INF/views/showKurssi.jsp";
    }
}
