package tenttiarkisto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tenttiarkisto.service.TenttiService;

@Controller
@RequestMapping("/tentit")
public class TenttiController {
    
    @Autowired TenttiService tenttiService;
    
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable Long id) {
        model.addAttribute("tentti", tenttiService.get(id));
        return "/WEB-INF/views/tentin-tiedot.jsp";
    }

    
}
