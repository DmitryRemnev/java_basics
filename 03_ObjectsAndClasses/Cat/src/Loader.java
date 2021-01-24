
public class Loader {

    public static void main(String[] args) {

        Cat cat = getKitten();
        System.out.println("Вес первого котёнка: " + cat.getWeight());
        cat.setColor(CatColors.BLACK);

        Cat cat2 = getKitten();
        System.out.println("Вес второго котёнка: " + cat2.getWeight());
        cat2.setColor(CatColors.GRAY);

        Cat cat3 = getKitten();
        System.out.println("Вес третьего котёнка: " + cat3.getWeight());
        cat3.setColor(CatColors.WHITE);
    }

    private static Cat getKitten() {
        return new Cat(1100.0);
    }
}