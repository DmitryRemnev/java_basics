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
    public void delete(@PathVariable AtomicLong id) {
        Storage.deleteToDo(id);
    }

    @PutMapping("/todo/{id}")
    public void update(@PathVariable AtomicLong id, ToDo toDo) {
        Storage.updateToDo(id, toDo);
    }

    @DeleteMapping("/todo/")
    public void deleteAll() {
        Storage.deleteAllToDo();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable AtomicLong id) {
        ToDo toDo = Storage.getToDo(id);
        if (toDo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(toDo, HttpStatus.OK);
    }
}