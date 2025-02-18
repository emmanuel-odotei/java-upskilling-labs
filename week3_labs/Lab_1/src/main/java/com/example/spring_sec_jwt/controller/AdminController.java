package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @GetMapping
    public String getAdmin(){
        return "Get Admin";
    }
    @PostMapping
    public String postAdmin(){
        return "Post Admin";
    }
    @PutMapping
    public String putAdmin(){
        return "Update Admin";
    }
}
