package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.service;

import com.example.spring_sec_jwt.entities.AuthenticationResponse;
import com.example.spring_sec_jwt.entities.User;
import com.example.spring_sec_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse register(User request){
       request.setPassword(passwordEncoder.encode(request.getPassword()));
       User saveUser =  userRepository.save(request);
       String token = jwtService.generateToken(saveUser);

       return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User userFromDB = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(userFromDB);
        return new AuthenticationResponse(token);
    }
}
