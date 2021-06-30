import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ParallelWriter extends RecursiveAction {
    public static final String PATH_TO_FILE = "C:\\Users\\Dmitry\\IdeaProjects\\java_basics\\16_Performance\\CarNumberGenerator\\src\\main\\resources\\numbers.txt";
    int numberCores = Runtime.getRuntime().availableProcessors();

    @Override
    protected void compute() {
        List<ParallelWriter> taskList = new ArrayList<>();

        for (int i = 0; i < numberCores; i++) {
            ParallelWriter task = new ParallelWriter();
            task.fork();
            taskList.add(task);
        }

        for (ParallelWriter task : taskList) {
            try (FileOutputStream writer = new FileOutputStream(PATH_TO_FILE)) {

                char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
                StringBuilder carNumber;
                for (int number = 1; number < 1000; number++) {
                    int regionCode = 199;
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                carNumber = new StringBuilder();
                                carNumber.append(firstLetter)
                                        .append(padNumber(number, 3))
                                        .append(secondLetter).append(thirdLetter)
                                        .append(padNumber(regionCode, 2));
                                writer.write(carNumber.toString().getBytes());
                                writer.write('\n');
                            }
                        }
                    }
                }

                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (taskList.size() > 0) {
            for (ParallelWriter task : taskList) {
                task.join();
            }
        }
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