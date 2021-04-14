import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        Path filePath = Paths.get(path);

        try {
            return Files.walk(filePath).map(Path::toFile).filter(File::isFile).mapToLong(File::length).sum();

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }

        final String[] units = new String[]{"Б", "КБ", "МБ", "ГБ", "ТБ"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));

        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups))
                + " " + units[digitGroups];
    }
}