public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String numbers = "0123456789";
        String sumString = "";
        boolean isAddToSum = false;
        int sumInt = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (isAddToSum && c == ' ') {
                sumInt += Integer.parseInt(sumString);
                sumString = "";
                isAddToSum = false;
            }

            if (numbers.indexOf(c) != -1) {
                isAddToSum = true;
                sumString += c;
            }
        }

        System.out.println(sumInt);
    }
}