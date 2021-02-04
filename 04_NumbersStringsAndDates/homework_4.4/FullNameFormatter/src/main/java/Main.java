import java.util.Scanner;

public class Main {

    public static final String VALID_CHARACTERS = " -АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯабвгдеёжзийклмнопрстуфхцчшщьыъэюя";

    public static void main(String[] args) {
        String surname = "";
        String name = "";
        String patronymic = "";
        int numOfString = 1;
        boolean isAddToString = false;
        boolean isValidationSuccessful = true;
        char c;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String trimString = input.trim();

            for (int i = 0; i < trimString.length(); i++) {
                c = trimString.charAt(i);

                if (isAddToString && c == ' ') {
                    isAddToString = false;
                    numOfString++;
                }

                if (VALID_CHARACTERS.indexOf(c) != -1) {
                    if (c != ' ') {
                        if (numOfString == 1) {
                            surname += c;
                        } else if (numOfString == 2) {
                            name += c;
                        } else if (numOfString == 3) {
                            patronymic += c;
                        } else {
                            isValidationSuccessful = false;
                        }
                        isAddToString = true;
                    }
                } else {
                    isValidationSuccessful = false;
                }
            }

            if (isValidationSuccessful && numOfString == 3) {
                System.out.format("Фамилия: %s%nИмя: %s%nОтчество: %s", surname, name, patronymic);
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }
}