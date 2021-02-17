public class Main {

    public static void main(String[] args) {
        char[][] xArray = TwoDimensionalArray.getTwoDimensionalArray(9);

        for (char[] chars : xArray) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}