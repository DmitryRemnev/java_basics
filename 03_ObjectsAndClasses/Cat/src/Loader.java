
public class Loader {

    public static void main(String[] args) {

        Cat cat = new Cat();
        System.out.println("Вес первого кота: " + cat.getWeight());

        Cat cat2 = new Cat(cat.getWeight());
        System.out.println("Вес второго кота: " + cat2.getWeight());
    }

    private static Cat getKitten() {
        return new Cat(1100.0);
    }
}