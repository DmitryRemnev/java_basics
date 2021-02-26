import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    public static final String EMAIL_PATTERN = "[A-Za-z@.]+$";
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    TreeSet<String> set = new TreeSet<>();

    public void add(String email) {

        if (isMailValid(email) && isContainsRequiredCharacters(email)) {
            set.add(email.toLowerCase());
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(set);
    }

    public void printList() {
        for (String item : set) {
            System.out.println(item);
        }
    }

    private boolean isMailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean isContainsRequiredCharacters(String email) {
        return email.contains("@") && email.contains(".");
    }
}