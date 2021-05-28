import java.io.File;
import java.util.*;

public class Main {
    public static final String SRC_FOLDER = "C:\\Users\\IGOR-K\\Desktop\\Pictures";
    public static final String DST_FOLDER = "C:\\Users\\IGOR-K\\Desktop\\Destination";
    public static final int NEW_WIDTH = 300;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        File srcDir = new File(SRC_FOLDER);

        int numberCores = Runtime.getRuntime().availableProcessors();

        File[] files = srcDir.listFiles();

        List<List<File>> listOfFiles = new ArrayList<>();
        for (int i = 0; i < numberCores; i++) {
            listOfFiles.add(new ArrayList<>());
        }

        if (files != null && files.length > 0) {

            for (int i = 0; i < files.length; i++) {
                int indexBucket = i % numberCores;
                listOfFiles.get(indexBucket).add(files[i]);
            }

            for (int i = 0; i < numberCores; i++) {

                List<File> list = listOfFiles.get(i);
                File[] array = new File[list.size()];

                for (int j = 0; j < list.size(); j++) {
                    array[j] = list.get(j);
                }

                ImageResizer imageResizer = new ImageResizer(array, NEW_WIDTH, DST_FOLDER, start);
                imageResizer.start();
            }
        }
    }
}