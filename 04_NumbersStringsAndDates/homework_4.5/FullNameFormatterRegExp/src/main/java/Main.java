import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Pattern PATTERN = Pattern.compile("[А-Яа-я-\\s]");

    public static void main(String[] args) {
        StringBuilder builderSurname = new StringBuilder();
        StringBuilder builderName = new StringBuilder();
        StringBuilder builderPatronymic = new StringBuilder();
        char c;
        int numOfString = 1;
        boolean isAddToString = false;
        boolean isValidationSuccessful = true;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String trimString = input.trim();

            for (int i = 0; i < trimString.length(); i++) {
                c = trimString.charAt(i);
                Matcher matcher = PATTERN.matcher(Character.toString(c));

                if (isAddToString && c == ' ') {
                    isAddToString = false;
                    numOfString++;
                }

                if (matcher.find()) {
                    if (c != ' ') {
                        if (numOfString == 1) {
                            builderSurname.append(c);
                        } else if (numOfString == 2) {
                            builderName.append(c);
                        } else if (numOfString == 3) {
                            builderPatronymic.append(c);
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
                System.out.format("Фамилия: %s%nИмя: %s%nОтчество: %s", builderSurname.toString(), builderName.toString(), builderPatronymic.toString());
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }
}