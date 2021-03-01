import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int intBoxes = Integer.parseInt(boxes);
        Calculation calculation = new Calculation(intBoxes);

        int containers = calculation.getContainerCount();
        int numberBoxes = 1;
        int numberContainers = 1;

        for (int i = 1; i <= calculation.getTruckCount(); i++) {
            System.out.println("Грузовик: " + i);

            for (int j = 1; j <= Calculation.MAX_TRUCK_VOLUME; j++) {
                if (containers != 0) {
                    System.out.println("\tКонтейнер: " + numberContainers);
                    containers--;
                    numberContainers++;
                }

                for (int k = 1; k <= Calculation.MAX_CONTAINER_VOLUME; k++) {
                    if (intBoxes != 0) {
                        System.out.println("\t\tЯщик: " + numberBoxes);
                        intBoxes--;
                        numberBoxes++;
                    }
                }
            }
        }

        System.out.println("Необходимо:\nгрузовиков - " + calculation.getTruckCount() + " шт.\nконтейнеров - " + calculation.getContainerCount() + " шт.");
    }
}
