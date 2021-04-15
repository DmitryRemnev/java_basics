import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите исходную папку:");
        String source = scanner.nextLine().trim();

        System.out.println("Введите папку назначения:");
        String destination = scanner.nextLine().trim();

        FileUtils.copyFolder(source, destination);
    }
}