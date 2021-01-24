
public class Cat {

    public static final int NUMBER_OF_EYES = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private static int count = 0;

    private double originWeight;
    private double weight;
    private double foodEaten;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        originWeight = weight;
    }

    public static int getCount() {
        return count;
    }

    public void pee() {
        if (isCatAlive()) {
            weight = weight - 40.0;
            System.out.println("Сходили в туалет");
        } else {
            System.out.println("Невозможно выполнить действие.");
        }
        minusCatIfItIsDead();
    }

    public double getFoodEaten() {
        return foodEaten;
    }

    public void meow() {
        if (isCatAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
        } else {
            System.out.println("Невозможно выполнить действие.");
        }
        minusCatIfItIsDead();
    }

    public void feed(Double amount) {
        if (isCatAlive()) {
            weight = weight + amount;
            foodEaten = foodEaten + amount;
        } else {
            System.out.println("Невозможно выполнить действие.");
        }
        minusCatIfItIsDead();
    }

    public void drink(Double amount) {
        if (isCatAlive()) {
            weight = weight + amount;
            foodEaten = foodEaten + amount;
        } else {
            System.out.println("Невозможно выполнить действие.");
        }
        minusCatIfItIsDead();
    }

    private boolean isCatAlive() {
        return (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT);
    }

    private void minusCatIfItIsDead() {
        if (!isCatAlive()) {
            count--;
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}