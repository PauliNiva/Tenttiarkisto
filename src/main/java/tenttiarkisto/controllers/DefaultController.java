
package tenttiarkisto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    
    @RequestMapping("/")
    String home() {
        return "Hello World ja automaattinen heroku päivityskin toimii";
    }
    
}
