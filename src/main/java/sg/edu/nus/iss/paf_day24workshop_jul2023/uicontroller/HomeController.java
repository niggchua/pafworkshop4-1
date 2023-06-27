package sg.edu.nus.iss.paf_day24workshop_jul2023.uicontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.paf_day24workshop_jul2023.model.Order;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Value("${home.title}") //the variable will be populated with this value
    private String homeTitle;

    @GetMapping
    public String welcome(Model model) {
        model.addAttribute("homeTitle", homeTitle);
        return "welcome"; //read the value, then use model object to inject into the page
    }
    @GetMapping("/orderadd")
    public String newOrderForm(Model model){
        Order order = new Order(); //the form need an empty object so the form will be able to ppopulate and update with the attribute data, and this is how we injected in. 
        //so to inject in, thymeleaf requires you to...
        model.addAttribute("order", order); //so the form is empty and will expect object to fill with this data
        return "orderadd";
    }

    @PostMapping("/ordernext")
    public String postOrderForm(@ModelAttribute("order") Order order) {
        System.out.println("HomeController > postOrderForm > " + order);

        return "orderadd";
    }


}
