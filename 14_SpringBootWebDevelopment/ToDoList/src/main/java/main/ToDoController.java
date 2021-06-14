package main;

import main.model.ToDo;
import main.model.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/todo/")
    public ResponseEntity<Object> list() {
        return new ResponseEntity<>(toDoService.getList(), HttpStatus.OK);
    }

    @PostMapping("/todo/")
    public ResponseEntity<Object> add(ToDo toDo) {
        return new ResponseEntity<>(toDoService.addToDo(toDo), HttpStatus.CREATED);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        toDoService.deleteTodo(id);
        return new ResponseEntity<>("Is deleted", HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Object> update(ToDo toDo) {
        toDoService.updateToDo(toDo);
        return new ResponseEntity<>("Is updated", HttpStatus.OK);
    }

    @DeleteMapping("/todo/")
    public ResponseEntity<Object> deleteAll() {
        toDoService.deleteAllToDo();
        return new ResponseEntity<>("Is deleted all", HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Object> get(@PathVariable long id) {

        Optional<ToDo> toDoOptional = toDoService.getToDo(id);

        if (!toDoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(toDoOptional.get(), HttpStatus.OK);
    }
}