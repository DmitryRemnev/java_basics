import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Pattern PATTERN = Pattern.compile("\\d");

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int sum = calculateSalarySum(text);

        if (sum > 0) {
            System.out.println(sum);
        } else {
            System.out.println("Никто ничего не заработал");
        }
    }

    public static int calculateSalarySum(String text) {

        StringBuilder builder = new StringBuilder();
        String sumString;
        boolean isAddToSum = false;
        int sumInt = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Matcher matcher = PATTERN.matcher(Character.toString(c));

            if (isAddToSum && c == ' ') {
                sumString = builder.toString();
                sumInt += Integer.parseInt(sumString);
                builder.setLength(0);
                isAddToSum = false;
            }

            if (matcher.find()) {
                builder.append(c);
                isAddToSum = true;
            }
        }

        return sumInt;
    }
}