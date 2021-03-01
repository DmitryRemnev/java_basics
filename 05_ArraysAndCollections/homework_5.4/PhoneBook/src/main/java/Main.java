public class Main {
    public static final String LIST_COMMAND = "LIST";

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Введите номер, имя или команду:");

        while (true) {
            String input = UserInput.getLine();

            if (input.equals("0")) {
                break;
            }

            if (input.equals(LIST_COMMAND)) {

                phoneBook.printList();

            } else {

                phoneBook.inputCheck(input.trim());

            }
        }
    }
}