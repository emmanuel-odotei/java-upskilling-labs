package week3_labs.lab_2.src.main.java.com.amalitech.lab_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUsers() {
        return "These are all users";
    }
}
