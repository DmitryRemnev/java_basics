import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = localDate.getYear() - year;

        Calendar dateOfBirth = new GregorianCalendar(year, month - 1, day);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.US);
        String text = "";
        boolean isEnteredDateLessThanCurrent = dateOfBirth.compareTo(Calendar.getInstance()) < 0;

        if (isEnteredDateLessThanCurrent) {
            int i = 0;
            do {
                Date nextDate = dateOfBirth.getTime();
                text = text + i + " - " + dateFormat.format(nextDate) + System.lineSeparator();
                dateOfBirth.add(Calendar.YEAR, 1);
                i++;
            } while (i < age);
        }

        return text;
    }
}