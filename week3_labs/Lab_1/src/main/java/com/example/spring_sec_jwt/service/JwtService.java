package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.service;

import com.example.spring_sec_jwt.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "71CE25FDCFB006904166075FD37EC01A91DFAB1F7810A30668CE9783AEF5282010581171215F991AE9859C1AF9D87B8146B1F2F989A3BBD87912F3D8E50A60B8";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }


    public boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);
        return username.equals(user.getUsername()) && isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractTokenExpiration(token).after(new Date(System.currentTimeMillis()));
    }

    private Date extractTokenExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(getSigninKey())
                .compact();

    }

    private SecretKey getSigninKey() {
        byte[] decodeKey = Decoders.BASE64.decode(SECRET_KEY); // decode the key from base64 encoded string to a byte array
        return Keys.hmacShaKeyFor(decodeKey); // generate a secret key object from the array of byte
    }
}
