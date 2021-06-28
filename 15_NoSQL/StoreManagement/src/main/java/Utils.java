import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final Pattern DIGIT_PATTERN = Pattern.compile("[\\d]");

    public static String getPrice(String text) {
        StringBuilder price = new StringBuilder();
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            Matcher matcher = DIGIT_PATTERN.matcher(Character.toString(c));
            if (matcher.find()) {
                price.append(c);
            }
        }

        return price.toString();
    }

    public static String getName(String text) {
        StringBuilder name = new StringBuilder();
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);

            if (c == ' ') {
                break;
            } else {
                name.append(c);
            }
        }

        return name.toString();
    }
}