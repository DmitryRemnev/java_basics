import java.util.Scanner;

public class Main {
    private static final String ENTER_PATH = "Введите путь до папки: ";
    private static final String FOLDER_SIZE = "Размер папки ";
    private static final String IS = " составляет ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            System.out.println(ENTER_PATH);

            String path = scanner.nextLine().trim();
            String data = FileUtils.readableFileSize(FileUtils.calculateFolderSize(path));

            System.out.println(FOLDER_SIZE + path + IS + data);
        }
    }
}