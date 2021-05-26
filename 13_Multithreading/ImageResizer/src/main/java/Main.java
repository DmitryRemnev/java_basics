import java.io.File;

public class Main {
    public static final String SRC_FOLDER = "C:\\Users\\IGOR-K\\Desktop\\Pictures";
    public static final String DST_FOLDER = "C:\\Users\\IGOR-K\\Desktop\\Destination";
    public static final int NEW_WIDTH = 300;

    public static void main(String[] args) {

        File srcDir = new File(SRC_FOLDER);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int numberCores = Runtime.getRuntime().availableProcessors();

        if (files != null && files.length > 0) {

            int separation = files.length / numberCores;

            for (int i = 0; i < numberCores; i++) {
                File[] file = new File[separation];
                System.arraycopy(files, 0, file, 0, file.length);
                ImageResizer imageResizer = new ImageResizer(file, NEW_WIDTH, DST_FOLDER, start);
                imageResizer.start();
            }
        }
    }
}