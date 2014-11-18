package tenttiarkisto.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tenttiarkisto.domain.Kurssi;
import tenttiarkisto.domain.Tentti;
import tenttiarkisto.domain.Tyyppi;
import tenttiarkisto.repo.TyyppiRepo;
import tenttiarkisto.service.KurssiService;
import tenttiarkisto.service.TenttiService;

@Controller
@RequestMapping("/tentit")
public class TenttiController {

    @Autowired
    TenttiService tenttiService;

    @Autowired
    KurssiService kurssiService;

    @Autowired
    TyyppiRepo tyyppiRepo;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable Long id) {
        model.addAttribute("tentti", tenttiService.get(id));

        //lomakkeelle
        model.addAttribute("kurssit", kurssiService.list());
        model.addAttribute("tyypit", tyyppiRepo.findAll());

        return "/WEB-INF/views/tentin-tiedot.jsp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(Model model, RedirectAttributes redirectAttributes,
            @RequestParam("tiedosto") MultipartFile file,
            @RequestParam("kurssi") String kurssiName,
            @RequestParam("pvm") String dateString,
            @RequestParam("tyyppi") Long tyyppiId,
            @RequestParam("kieli") String kieli,
            @RequestParam("pitaja") String pitaja) throws IOException, ParseException {

        Category log = Logger.getInstance(TenttiController.class);
        log.info("file: " + file.getOriginalFilename());
        log.info("kurssi: " + kurssiName);
        log.info("pvm: " + dateString);
        log.info("tyyppi: " + tyyppiId);
        log.info("kieli: " + kieli);
        log.info("pitaja: " + pitaja);

        Kurssi kurssi = kurssiService.findByName(kurssiName);
        if (kurssi == null) {
            kurssi = kurssiService.addKurssi(kurssiName);
        }

        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1);
        log.info("ext: " + ext);

        Tyyppi tyyppi = tyyppiRepo.findOne(tyyppiId);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse(dateString);
        log.info("date: " + date);

        Tentti tentti = new Tentti(date, pitaja, kurssi, tyyppi, kieli, null);

        Long id = tenttiService.addTentti(tentti, file.getInputStream(), file.getSize(), ext);
        log.info("id: " + id);

        redirectAttributes.addAttribute("id", id);

        return "redirect:/tentit/{id}";
    }
}
