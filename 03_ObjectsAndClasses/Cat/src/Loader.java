
public class Loader {

    public static void main(String[] args) {

        // 1.Выведите в консоль вес созданных кошек.
        Cat cat = new Cat();
        System.out.println("Вес первого кота: " + cat.getWeight());

        Cat cat2 = new Cat();
        System.out.println("Вес второго кота: " + cat2.getWeight());

        Cat cat3 = new Cat();
        System.out.println("Вес третьего кота: " + cat3.getWeight());

        Cat cat4 = new Cat();
        System.out.println("Вес четвёртого кота: " + cat4.getWeight());

        Cat cat5 = new Cat();
        System.out.println("Вес пятого кота: " + cat5.getWeight());
        System.out.println();


        // 2.Покормите двух кошек, после этого распечатайте их вес (убедитесь, что вес изменился).
        System.out.println("Вес первого кота: " + cat.getWeight());
        cat.feed(220.0);
        cat.drink(90.0);
        System.out.println("Вес первого кота: " + cat.getWeight());

        System.out.println("Вес второго кота: " + cat2.getWeight());
        cat2.feed(150.0);
        cat2.drink(85.0);
        System.out.println("Вес второго кота: " + cat2.getWeight());
        System.out.println();

        // 3.Перекормите кошку, чтобы ее статус стал Exploded.
        while (cat.getWeight() <= cat.getMaxWeight()) {
            cat.drink(1.0);
        }
        System.out.println("Статус первого кота: " + cat.getStatus());
        System.out.println();

        // 4.«Замяукайте» кошку до статуса Dead.
        while (cat2.getWeight() >= cat2.getMinWeight()) {
            cat2.meow();
        }
        System.out.println("Статус второго кота: " + cat2.getStatus());
    }
}