package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @GetMapping
    public String getManager() {
        return "Manager::Get";
    }
    @PutMapping
    public String putManager() {
        return "Manager::Put";
    }
    @PostMapping
    public String postManager() {
        return "Manager::Post";
    }
    @DeleteMapping
    public String deleteManager() {
        return "Manager::Delete";
    }
}
