
public class Loader {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.pee();

        Cat cat2 = new Cat();
        cat2.meow();

        Cat cat3 = new Cat();
        cat3.feed(100.0);

        Cat cat4 = new Cat();
        cat4.drink(70.0);

        System.out.println(Cat.getCount());
    }
}