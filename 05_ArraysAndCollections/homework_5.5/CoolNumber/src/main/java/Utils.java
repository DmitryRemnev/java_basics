public class Utils {
    private static long startTime;
    private static long endTime;

    public static void begin() {
        startTime = System.nanoTime();
    }

    public static void end() {
        endTime = System.nanoTime();
    }

    public static long duration() {
        long duration = endTime - startTime;
        startTime = 0;
        endTime = 0;

        return duration;
    }
}