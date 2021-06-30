import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Loader {
    public static final String PATH_TO_FILE = "C:\\Users\\Dmitry\\IdeaProjects\\java_basics\\16_Performance\\CarNumberGenerator\\src\\main\\resources\\numbers.txt";

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 1; i <= Runtime.getRuntime().availableProcessors(); i++) {
            ParallelWriter task = new ParallelWriter("Task" + i, PATH_TO_FILE + i);
            executor.execute(task);

        }
        executor.shutdown();
    }
}