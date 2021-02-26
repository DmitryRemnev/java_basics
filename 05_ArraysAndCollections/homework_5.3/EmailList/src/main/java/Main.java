public class Main {

    public static final String LIST_COMMAND = "LIST";
    public static final String ADD_COMMAND = "ADD";

    public static void main(String[] args) {
        EmailList emailList = new EmailList();

        while (true) {

            String input = UserInput.getLine();

            if (input.equals("0")) {
                break;
            }

            if (input.equals(ADD_COMMAND)) {
                emailList.add(input.replaceFirst(ADD_COMMAND, "").trim());

            } else if (input.startsWith(LIST_COMMAND)) {
                emailList.printList();

            } else {
                System.out.println("Введите команду!");
            }
        }
    }
}