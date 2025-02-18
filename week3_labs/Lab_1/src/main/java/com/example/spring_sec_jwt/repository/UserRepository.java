package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.repository;

import com.example.spring_sec_jwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
