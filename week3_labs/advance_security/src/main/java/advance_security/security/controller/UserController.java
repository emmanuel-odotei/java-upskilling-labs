package advance_security.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    // Home page - Thymeleaf template
    @GetMapping("/home")
    public String home() {
        return "home"; // This will look for 'home.html' in src/main/resources/templates
    }
    
    // User details endpoint (to display user info)
    @GetMapping("/user")
    public String getUser(Authentication authentication, Model model) {
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            
            // Check if the principal is an instance of OidcUser
            if (principal instanceof OidcUser) {
                OidcUser oidcUser = (OidcUser) principal;
                
                // Retrieve user details from the OidcUser object
                String username = oidcUser.getFullName(); // Name of the user
                String email = oidcUser.getEmail(); // Email address
                String gender = oidcUser.getClaims().getOrDefault("gender", "Not specified").toString(); // Gender
                
                // Pass the user details to the Thymeleaf model
                model.addAttribute("name", username);
                model.addAttribute("email", email);
                model.addAttribute("gender", gender);
                
                // Return the 'user.html' template to display user info
                return "user";
            } else {
                return "No OIDC user!";
            }
        } else {
            return "No user is currently authenticated.";
        }
    }
}
