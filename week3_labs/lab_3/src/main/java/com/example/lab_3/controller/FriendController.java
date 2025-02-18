package week3_labs.lab_3.src.main.java.com.example.lab_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendController {
    @GetMapping("/")
    public String home() {
        return "GET::Home endpoint";
    }

    @GetMapping("/friends")
    public String listFriends() {
        return "GET::Friends endpoint";
    }

    @GetMapping("/friends/{id}")
    public String viewFriendProfile(@PathVariable int id) {
        return "GET::Friend" + id + "endpoint";
    }

    @PostMapping("/friends")
    public String addFriend() {
        return "POST::Friend endpoint";
    }
}
