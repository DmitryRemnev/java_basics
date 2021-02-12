import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static final String DATE_PATTERN = "dd.MM.yyyy - E";

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.ENGLISH);
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (today.isAfter(birthday) || today.isEqual(birthday)) {
            builder.append(i).append(" - ").append(birthday.format(printFormat)).append(System.lineSeparator());
            birthday = birthday.plusYears(1);
            i++;
        }

        return builder.toString();
    }
}