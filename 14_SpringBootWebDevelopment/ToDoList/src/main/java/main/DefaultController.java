package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> list = new ArrayList<>();
        for (ToDo toDo : toDoIterable) {
            list.add(toDo);
        }
        model.addAttribute("todo", list);
        model.addAttribute("todoCount", list.size());

        return "index";
    }
}