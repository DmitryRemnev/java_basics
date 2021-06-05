import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {

        Node root = null;

        List<String> list = new ForkJoinPool().invoke(new NodeListProcessor(root));

        list.forEach(System.out::println);
    }
}