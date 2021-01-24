
public class Loader {

    public static void main(String[] args) {

        Cat cat = getKitten();
        System.out.println("Вес первого котёнка: " + cat.getWeight());

        Cat cat2 = getKitten();
        System.out.println("Вес второго котёнка: " + cat2.getWeight());

        Cat cat3 = getKitten();
        System.out.println("Вес третьего котёнка: " + cat3.getWeight());
    }

    private static Cat getKitten() {
        return new Cat(1100.0);
    }
}