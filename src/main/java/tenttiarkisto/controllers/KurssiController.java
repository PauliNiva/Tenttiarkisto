package tenttiarkisto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tenttiarkisto.repo.KieliRepo;
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
    
    @Autowired
    KieliRepo kieliRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("kurssit", kurssiService.list());
        model.addAttribute("tyypit", tyyppiRepo.findAll());
        model.addAttribute("kielet", kieliRepo.findAll());
        return "/WEB-INF/views/index.jsp";
    }
}
