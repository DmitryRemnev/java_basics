package main;

import main.model.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ToDoController {

    @GetMapping("/todo/")
    public List<ToDo> list() {
        return Storage.getAllToDo();
    }

    @PostMapping("/todo/")
    public AtomicLong add(ToDo toDo) {
        return Storage.addToDo(toDo);
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable long id) {
        Storage.deleteToDo(new AtomicLong(id));
    }

    @PutMapping("/todo/{id}")
    public void update(@PathVariable long id, ToDo toDo) {
        Storage.updateToDo(new AtomicLong(id), toDo);
    }

    @DeleteMapping("/todo/")
    public void deleteAll() {
        Storage.deleteAllToDo();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable long id) {
        ToDo toDo = Storage.getToDo(new AtomicLong(id));
        if (toDo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(toDo, HttpStatus.OK);
    }
}