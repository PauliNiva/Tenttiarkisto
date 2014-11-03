package tenttiarkisto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    
    @RequestMapping("/")
    public String view(Model model) {
        model.addAttribute("viesti", "Viestitellään");
        return "WEB-INF/views/index.jsp";
    }

}
