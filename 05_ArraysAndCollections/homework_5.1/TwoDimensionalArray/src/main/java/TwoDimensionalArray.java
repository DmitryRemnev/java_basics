public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] xArray = new char[size][size];
        int begin = 0;
        int end = size - 1;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (j == begin || j == end) {
                    xArray[i][j] = symbol;
                } else {
                    xArray[i][j] = ' ';
                }
            }

            begin++;
            end--;
        }

        return xArray;
    }
}