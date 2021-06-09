package main;

import main.model.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class Storage {

    private static ConcurrentMap<AtomicLong, ToDo> toDoList = new ConcurrentHashMap<>();
    private static AtomicLong currentId = new AtomicLong(1);

    public static List<ToDo> getAllToDo() {
        return new ArrayList<>(toDoList.values());
    }

    public static AtomicLong addToDo(ToDo toDo) {
        AtomicLong id = new AtomicLong(currentId.getAndIncrement());
        toDo.setId(id);
        toDoList.put(id, toDo);

        return id;
    }

    public static void deleteToDo(AtomicLong id) {
        toDoList.remove(id);
    }

    public static void updateToDo(AtomicLong id, ToDo toDo) {
        toDoList.replace(id, toDo);
    }

    public static void deleteAllToDo() {
        toDoList.clear();
    }

    public static ToDo getToDo(AtomicLong id) {
        if (toDoList.containsKey(id)) {
            return toDoList.get(id);
        }

        return null;
    }
}