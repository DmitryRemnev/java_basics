import java.util.regex.Pattern;

public class Main {
    public static final Pattern CLEAR_PATTERN = Pattern.compile("[\\p{Punct}\\d]");
    public static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");
    public static final String SPACE = " ";
    public static final String LINE_BREAK = "\n";

    public static void main(String[] args) {
        System.out.println(splitTextIntoWords("a b c"));
    }

    public static String splitTextIntoWords(String text) {

        return text.replaceAll(String.valueOf(CLEAR_PATTERN), SPACE).replaceAll(String.valueOf(SPACE_PATTERN), LINE_BREAK).trim();
    }
}