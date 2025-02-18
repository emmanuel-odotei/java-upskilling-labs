package week3_labs.Lab_1.src.test.java.com.example.spring_sec_jwt.service;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Arrays;


@SpringBootTest
public class JwtSecretTest {
    @Test
    void generateSecret() {

        SecretKey key = Jwts.SIG.HS512.key().build();
        String endcodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("[%s]", endcodedKey);
    }

    @Test
    void testLoop(){
       byte a = 1;

       int b = 128;

       a = (byte) b;
       System.out.println(a);
    }
}
