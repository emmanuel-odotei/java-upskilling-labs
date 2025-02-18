package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.controller;

import com.example.spring_sec_jwt.entities.AuthenticationResponse;
import com.example.spring_sec_jwt.entities.User;
import com.example.spring_sec_jwt.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }
}
