package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todo/")
    public List<ToDo> list() {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();

        ArrayList<ToDo> list = new ArrayList<>();
        for (ToDo toDo : toDoIterable) {
            list.add(toDo);
        }

        return list;
    }

    @PostMapping("/todo/")
    public Long add(ToDo toDo) {
        ToDo newToDo = toDoRepository.save(toDo);
        return newToDo.getId();
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable long id) {
        toDoRepository.deleteById(id);
    }

    @PutMapping("/todo/{id}")
    public void update(@PathVariable long id, ToDo toDo) {
        toDoRepository.save(toDo);
    }

    @DeleteMapping("/todo/")
    public void deleteAll() {
        toDoRepository.deleteAll();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable long id) {

        Optional<ToDo> toDoOptional = toDoRepository.findById(id);

        if (!toDoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity(toDoOptional.get(), HttpStatus.OK);
    }
}