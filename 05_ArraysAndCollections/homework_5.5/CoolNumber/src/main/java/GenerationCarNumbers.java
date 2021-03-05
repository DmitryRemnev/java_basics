public class GenerationCarNumbers {
    private final char[] chars = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

    String getCarNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getChar(1)).append(getDigits()).append(getChar(2)).append(getRegion());

        return stringBuilder.toString();
    }

    private String getChar(int count) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int index = (int) (Math.random() * 12);
            stringBuilder.append(chars[index]);
        }

        return stringBuilder.toString();
    }

    private String getDigits() {
        StringBuilder stringBuilder = new StringBuilder();
        int min = 1;
        int max = 9;

        max -= min;
        int digit = (int) ((Math.random() * ++max) + min);

        return stringBuilder.append(digit).append(digit).append(digit).toString();
    }

    private String getRegion() {
        StringBuilder stringBuilder = new StringBuilder();
        int min = 1;
        int max = 199;

        max -= min;
        int digit = (int) ((Math.random() * ++max) + min);

        if (digit < 10) {
            return stringBuilder.append(0).append(digit).toString();
        } else {
            return stringBuilder.append(digit).toString();
        }
    }
}