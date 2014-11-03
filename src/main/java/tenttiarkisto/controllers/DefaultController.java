
package tenttiarkisto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class DefaultController {
    
    @RequestMapping("/")
    public String view(Model model) {
	model.addAttribute("viesti", "gagaeeagf");
        return "WEB-INF/views/index.jsp";
    }
    
}
