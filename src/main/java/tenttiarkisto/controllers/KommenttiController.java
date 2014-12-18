package tenttiarkisto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tenttiarkisto.domain.Kommentti;
import tenttiarkisto.repo.KieliRepo;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.KommenttiService;
import tenttiarkisto.service.KurssiService;
import tenttiarkisto.service.TenttiService;

@Controller
@RequestMapping(value = "/tentit")
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

    @RequestMapping(value = "/{id}/kommentit", method = RequestMethod.POST)
    public String addKommentti(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes,
            @RequestParam("nimi") String nimi,
            @RequestParam("kommentti") String kommentti) {

        Kommentti k = new Kommentti();
        k.setKirjoittaja(nimi);
        k.setSisalto(kommentti);
        k.setKommentoituTentti(tenttiService.get(id));

        kommenttiService.addKommentti(k);

        redirectAttributes.addAttribute("id", id);
        return "redirect:/tentit/{id}";
    }

    @RequestMapping(value = "/{id}/kommentit/{kommentinId}", method = RequestMethod.DELETE)
    public String deleteKommentti(@PathVariable Long id, @PathVariable Long kommentinId, RedirectAttributes redirectAttributes) {
        kommenttiService.removeKommentti(kommentinId);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/tentit/{id}";
    }
}
