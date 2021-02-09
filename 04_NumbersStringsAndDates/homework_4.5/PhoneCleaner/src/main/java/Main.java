import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final Pattern CLEAR_PATTERN = Pattern.compile("[^\\d]");

    public static void main(String[] args) {
        boolean isCorrectCountryCode = false;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String cleanText = input.replaceAll(CLEAR_PATTERN.toString(), "");

            if (cleanText.length() == 11) {
                char c = cleanText.charAt(0);

                if (c == '7') {
                    isCorrectCountryCode = true;
                } else if (c == '8') {
                    isCorrectCountryCode = true;
                    cleanText = cleanText.replace("8", "7");
                } else {
                    isCorrectCountryCode = false;
                }
            } else if (cleanText.length() == 10) {
                cleanText = "7" + cleanText;
                isCorrectCountryCode = true;
            }

            if (isCorrectCountryCode) {
                System.out.println(cleanText);
            } else {
                System.out.println("Неверный формат номера");
            }
        }
    }
}