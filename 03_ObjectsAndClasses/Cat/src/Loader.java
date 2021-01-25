
public class Loader {

    public static void main(String[] args) {

        Cat cat = new Cat();
        System.out.println("Данные первого кота:");
        System.out.println(cat.getWeight());
        System.out.println(cat.getOriginWeight());
        System.out.println(cat.getFoodEaten());
        System.out.println(cat.getColor());
        System.out.println();

        Cat cat2 = Cat.copy(cat);
        System.out.println("Данные второго кота:");
        System.out.println(cat2.getWeight());
        System.out.println(cat2.getOriginWeight());
        System.out.println(cat2.getFoodEaten());
        System.out.println(cat2.getColor());
    }
}