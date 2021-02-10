import java.util.regex.Pattern;

public class Main {
    public static final Pattern PATTERN = Pattern.compile("<.+?>");

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        return text.replaceAll(PATTERN.toString(), placeholder);
    }
}