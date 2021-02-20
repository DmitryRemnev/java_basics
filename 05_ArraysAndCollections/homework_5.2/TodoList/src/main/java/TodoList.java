import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        list.add(todo);
    }

    public void add(int index, String todo) {

        if (index >= 0 && index < list.size()) {
            list.add(index, todo);
        } else {
            add(todo);
        }
    }

    public void edit(String todo, int index) {
        if (index >= 0 && index < list.size()) {
            list.set(index, todo);
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

    public ArrayList<String> getTodos() {
        return list;
    }
}