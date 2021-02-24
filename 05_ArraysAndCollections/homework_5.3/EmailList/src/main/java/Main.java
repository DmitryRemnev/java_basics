import java.util.Scanner;

public class Main {
    public static final String LIST_COMMAND = "LIST";
    public static final String ADD_COMMAND = "ADD";
    private static final EmailList emailList = new EmailList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            if (input.contains(LIST_COMMAND)) {

                for (String item : emailList.getSortedEmails()) {
                    System.out.println(item);
                }

            } else if (input.contains(ADD_COMMAND)) {

                input = input.replace(ADD_COMMAND, "").trim();
                emailList.add(input);

            } else {
                System.out.println("Введите команду!");
            }
        }
    }
}