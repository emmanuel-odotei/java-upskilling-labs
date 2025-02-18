package Week;

import com.amalitech.lab_2_mvc_db.entity.TodoEntity;
import com.amalitech.lab_2_mvc_db.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public String todos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todo";
    }

    @PostMapping("/todos/add")
    public String addTodo(@ModelAttribute("todo") TodoEntity todo, Model model) {
        todoRepository.save(todo);
        model.addAttribute("todos", todoRepository.findAll());
        return "todo";
    }

    @PostMapping("/todos/complete/{id}")
    public String completeTodo(@PathVariable Long id, Model model) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
        model.addAttribute("todos", todoRepository.findAll());
        return "todo";
    }
}
