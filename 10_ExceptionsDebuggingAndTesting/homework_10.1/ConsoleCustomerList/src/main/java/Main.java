import exceptions.IncorrectMailException;
import exceptions.IncorrectPhoneException;
import exceptions.WrongWordCountException;

import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;
    private static final String WRONG_WORD_COUNT = "Неверное количество слов";
    private static final String INCORRECT_MAILING_ADDRESS = "Некорректный почтовый адрес";
    private static final String INVALID_PHONE_NUMBER = "Некорректный номер телефона";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            if (tokens[0].equals("add")) {
                try {
                    executor.addCustomer(tokens[1]);
                } catch (WrongWordCountException exception) {
                    System.out.println(WRONG_WORD_COUNT);
                } catch (IncorrectMailException exception) {
                    System.out.println(INCORRECT_MAILING_ADDRESS);
                } catch (IncorrectPhoneException exception) {
                    System.out.println(INVALID_PHONE_NUMBER);
                }
            } else if (tokens[0].equals("list")) {
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                executor.removeCustomer(tokens[1]);
            } else if (tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                System.out.println(helpText);
            } else {
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}