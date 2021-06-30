import java.io.FileOutputStream;
import java.util.List;

public class ParallelWriter implements Runnable {
    private final long start;
    private final String path;
    private final List<String> list;

    public ParallelWriter(long start, String path, List<String> list) {
        this.start = start;
        this.path = path;
        this.list = list;
    }

    @Override
    public void run() {
        try (FileOutputStream writer = new FileOutputStream(path)) {

            for (String number : list) {
                writer.write(number.getBytes());
                writer.write('\n');
            }

            writer.flush();
            System.out.println((System.currentTimeMillis() - start) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}