public class Main {

    public static void main(String[] args) {

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alphabet.length(); i++) {
            int code = alphabet.charAt(i);
            System.out.println("Символ: " + alphabet.charAt(i) + "\tКод: " + code);
        }
    }
}
