public class Main {
    private static Integer firstIndex;

    public static void main(String[] args) {

        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        boolean beginReplacement = false;

        if (text.length() > 0) {

            for (int i = 0; i < text.length(); i++) {

                if (text.charAt(i) == '<') {
                    firstIndex = i;
                    beginReplacement = true;
                }

                if (text.charAt(i) == '>' && beginReplacement) {
                    text = text.substring(0, firstIndex) + placeholder + text.substring(i + 1);
                    beginReplacement = false;
                }
            }
        }

        return text;
    }
}