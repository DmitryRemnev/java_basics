import java.util.concurrent.ForkJoinPool;

public class Loader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ParallelWriter parallelWriter = new ParallelWriter();
        ForkJoinPool.commonPool().invoke(parallelWriter);

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}