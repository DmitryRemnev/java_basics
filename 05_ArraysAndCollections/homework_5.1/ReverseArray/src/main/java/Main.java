public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] strings = line.split(",?\\s+");
        ReverseArray.reverse(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}