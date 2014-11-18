package tenttiarkisto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tyyppi;
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
    CSVService csvService;

    @RequestMapping("/")
    public String view() {
        return "redirect:/kurssit";
    }

    @RequestMapping("/initializekurssit")
    @ResponseBody
    public String init() {
        for (Kurssi kurssi : csvService.readCSV()) {
            kurssiService.addKurssi(kurssi);
        }

        Tyyppi kk = new Tyyppi();
        kk.setTyyppi("Kurssikoe");
        tyyppiRepo.save(kk);

        Tyyppi ek = new Tyyppi();
        ek.setTyyppi("Erilliskoe");
        tyyppiRepo.save(ek);
        
        return "Done";
    }

}
