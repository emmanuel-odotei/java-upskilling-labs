package intermediate.week2_labs.mvc.src.main.java.com.amalitech.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "todo";
    }
}
