package intermediate.week2_labs.mvc.src.main.java.com.amalitech.mvc.repository;

import com.amalitech.lab_2_mvc_db.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
