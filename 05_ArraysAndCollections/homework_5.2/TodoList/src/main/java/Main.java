import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String LIST_COMMAND = "LIST";
    public static final String ADD_COMMAND = "ADD";
    public static final String EDIT_COMMAND = "EDIT";
    public static final String DELETE_COMMAND = "DELETE";
    public static final Pattern DIGIT_PATTERN = Pattern.compile("[\\d]");

    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();
            if (text.equals("")) {
                break;
            }

            if (text.contains(LIST_COMMAND)) {

                for (String item : todoList.getTodos()) {
                    System.out.println(item);
                }

            } else if (text.contains(ADD_COMMAND)) {

                text = text.replace(ADD_COMMAND, "").trim();

                String index = getIndex(text);
                if (index.equals("")) {
                    todoList.add(text);
                } else {
                    text = text.replace(index, "").trim();
                    todoList.add(Integer.parseInt(index), text);
                }

            } else if (text.contains(EDIT_COMMAND)) {

                text = text.replace(EDIT_COMMAND, "").trim();

                String index = getIndex(text);
                if (!index.equals("")) {
                    text = text.replace(index, "").trim();
                    todoList.edit(text, Integer.parseInt(index));
                }

            } else if (text.contains(DELETE_COMMAND)) {

                text = text.replace(DELETE_COMMAND, "").trim();

                String index = getIndex(text);
                if (!index.equals("")) {
                    todoList.delete(Integer.parseInt(index));
                }

            } else {
                System.out.println("Введите команду!");
            }
        }
    }

    public static String getIndex(String text) {
        String index = "";
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            Matcher matcher = DIGIT_PATTERN.matcher(Character.toString(c));
            if (matcher.find()) {
                index = index + c;
            }
        }

        return index;
    }
}