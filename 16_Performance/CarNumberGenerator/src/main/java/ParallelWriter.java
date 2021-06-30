import java.io.FileOutputStream;

public class ParallelWriter implements Runnable {
    private String name;
    private String path;

    public ParallelWriter(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try (FileOutputStream writer = new FileOutputStream(path)) {

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
            System.out.println((System.currentTimeMillis() - start) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
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