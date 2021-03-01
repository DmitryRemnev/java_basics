import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsCorrect {
    public static final String NAME_PATTERN = "[А-Яа-я]+$";
    public static final String PHONE_PATTERN = "[\\d]+$";
    public static final int NUMBER_DIGITS_PHONE = 11;

    static boolean isNameCorrect(String name) {
        Pattern namePattern = Pattern.compile(NAME_PATTERN);
        Matcher nameMatcher = namePattern.matcher(name);

        return nameMatcher.matches();
    }

    static boolean isPhoneCorrect(String phone) {
        Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
        Matcher phoneMatcher = phonePattern.matcher(phone);

        return phoneMatcher.matches() && phone.length() == NUMBER_DIGITS_PHONE;
    }
}