package sg.edu.nus.iss.paf_day24workshop_jul2023.uicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String welcome() {
        return "welcome";
    }
    
}
