package advance_security.security.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OidcUser> {
    
    
    @Override
    public OidcUser loadUser (OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // Cast to OidcUserRequest to get the ID token
        OidcUserRequest oidcUserRequest = (OidcUserRequest) userRequest;
        
        // Now you can retrieve the ID token
        OidcIdToken idToken = oidcUserRequest.getIdToken();
        
        // Extract claims from the ID token
        Map<String, Object> claims = idToken.getClaims();
        
        // Extract the email from the claims (example)
        String email = (String) claims.get( "email" );
        System.out.println( "User Email: " + email );
        
        // Create authorities (e.g., ROLE_USER)
        List<SimpleGrantedAuthority> authorities = Collections.singletonList( new SimpleGrantedAuthority( "ROLE_USER" ) );
        
        // Return a new OidcUser with authorities and the ID token
        return new DefaultOidcUser( authorities, idToken );
    }
}