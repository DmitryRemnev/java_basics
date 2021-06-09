package main;

import main.model.ToDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private static HashMap<Integer, ToDo> toDoList = new HashMap<>();
    private static int currentId = 1;

    public static List<ToDo> getAllToDo() {
        return new ArrayList<>(toDoList.values());
    }

    public static int addToDo(ToDo toDo) {
        int id = currentId++;
        toDo.setId(id);
        toDoList.put(id, toDo);

        return id;
    }

    public static void deleteToDo(int id) {
        toDoList.remove(id);
    }

    public static void updateToDo(int id, ToDo toDo) {
        toDoList.replace(id, toDo);
    }

    public static void deleteAllToDo() {
        toDoList.clear();
    }

    public static ToDo getToDo(int id) {
        if (toDoList.containsKey(id)) {
            return toDoList.get(id);
        }

        return null;
    }
}