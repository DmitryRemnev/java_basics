public class TextUtil {
    static String surname;
    static String name;
    static String patronymic;
    public static final String VALID_CHARACTERS = " -АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯабвгдеёжзийклмнопрстуфхцчшщьыъэюя";

    public static void divideText(String text) {
        surname = "";
        name = "";
        patronymic = "";

        char c;
        boolean isAddToString = false;
        int numOfString = 1;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);

            if (isAddToString && c == ' ') {
                isAddToString = false;
                numOfString++;
            }

            if (VALID_CHARACTERS.indexOf(c) != -1) {
                if (c != ' ') {
                    if (numOfString == 1) {
                        surname += c;
                    } else if (numOfString == 2) {
                        name += c;
                    } else if (numOfString == 3) {
                        patronymic += c;
                    }
                    isAddToString = true;
                }
            }
        }
    }
}