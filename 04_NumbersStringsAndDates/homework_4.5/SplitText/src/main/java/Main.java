public class Main {

    public static void main(String[] args) {
        System.out.println(splitTextIntoWords("a b c"));
    }

    public static String splitTextIntoWords(String text) {

        String clean = text.replaceAll("[^A-Za-z\\s-’]", "");
        String cleanDash = clean.replaceAll("-", " ");
        return cleanDash.replaceAll("( )+", "\n");
    }
}