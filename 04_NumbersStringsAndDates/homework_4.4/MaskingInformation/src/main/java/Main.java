public class Main {
    private static Integer firstIndex;
    private static Integer secondIndex;

    public static void main(String[] args) {

        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        if (text.length() > 0) {

            for (int i = 0; i < text.length(); i++) {

                if (text.charAt(i) == '<') {
                    firstIndex = i;
                }
                if (text.charAt(i) == '>') {
                    secondIndex = i;
                }
            }

            if ((firstIndex != null) && (secondIndex != null)) {
                text = text.substring(0, firstIndex) + placeholder + text.substring(secondIndex + 1);
            }
        }

        return text;
    }
}