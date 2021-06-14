package main.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getList() {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();

        ArrayList<ToDo> list = new ArrayList<>();
        for (ToDo toDo : toDoIterable) {
            list.add(toDo);
        }

        return list;
    }

    public Long addToDo(ToDo toDo) {
        ToDo newToDo = toDoRepository.save(toDo);
        return newToDo.getId();
    }

    public void deleteTodo(@PathVariable long id) {
        toDoRepository.deleteById(id);
    }

    public void updateToDo(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    public void deleteAllToDo() {
        toDoRepository.deleteAll();
    }

    public Optional<ToDo> getToDo(@PathVariable long id) {
        return toDoRepository.findById(id);
    }
}