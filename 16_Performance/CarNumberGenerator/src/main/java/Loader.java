import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Loader {
    public static final String PATH_TO_FILE = "C:\\Users\\Dmitry\\IdeaProjects\\java_basics\\16_Performance\\CarNumberGenerator\\src\\main\\resources\\numbers.txt";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<String> numbers = new ArrayList<>();
        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder carNumber = new StringBuilder();
        for (int number = 1; number < 1000; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        carNumber.append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter).append(thirdLetter)
                                .append(padNumber(regionCode, 2));
                        numbers.add(carNumber.toString());
                        carNumber.setLength(0);
                    }
                }
            }
        }

        List<List<String>> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            listOfNumbers.add(new ArrayList<>());
        }

        for (int i = 0; i < numbers.size(); i++) {
            int index = i % 2;
            listOfNumbers.get(index).add(numbers.get(i));
        }

        for (int i = 0; i < 2; i++) {
            ParallelWriter task = new ParallelWriter(start, PATH_TO_FILE + i, listOfNumbers.get(i));
            executor.execute(task);
        }
        executor.shutdown();
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }
}