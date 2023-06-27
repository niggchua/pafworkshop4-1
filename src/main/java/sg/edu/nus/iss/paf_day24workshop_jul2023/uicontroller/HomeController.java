package sg.edu.nus.iss.paf_day24workshop_jul2023.uicontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.edu.nus.iss.paf_day24workshop_jul2023.model.Order;
import sg.edu.nus.iss.paf_day24workshop_jul2023.model.OrderDetails;

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
    public String postOrderForm(HttpSession session, @ModelAttribute("order") Order order) {
//System.out.println("HomeController > postOrderForm > " + order); //when the data is post, we see whether can not,
        session.setAttribute("order", order);   //then we store it inside this order form

        return "redirect:/home/orderdetailadd"; //then we create this page and we throw this page
        //without redirect, we go straight to orderdetailadd, when we use redirect, we are running the below code first then bringing us to the orderdetailadd endpoint
    }

    @GetMapping("/orderdetailadd")
    public String newOrderDetailForm(Model model) {
        OrderDetails orderDetails = new OrderDetails();
        model.addAttribute("orderDetails", orderDetails);

        return "orderdetailadd"; 
    }
      //a html page a response is a string, when you return a string, you return a html page

      @PostMapping("nextdetails")
      public String postOrderDetails(HttpSession session, @ModelAttribute("orderdetails") OrderDetails orderDetails, Model model){
        System.out.println("HomeController > ")
      }


}
