
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodEaten;

    private static int count;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

        count++;
    }

    public static int getCount() {
        return count;
    }

    public void pee() {
        if (isDead()) {
            System.out.println("Невозможно выполнить действие - кошка мертва.");
        } else {
            weight = weight - 40.0;
            System.out.println("Сходили в туалет");
            minusCat(isDead());
        }
    }

    public double getFoodEaten() {
        return foodEaten;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void meow() {
        if (isDead()) {
            System.out.println("Невозможно выполнить действие - кошка мертва.");
        } else {
            weight = weight - 1;
            System.out.println("Meow");
            minusCat(isDead());
        }
    }

    public void feed(Double amount) {
        if (isExploded()) {
            System.out.println("Невозможно выполнить действие - кошка взорвалась.");
        } else {
            weight = weight + amount;
            foodEaten = foodEaten + amount;
            minusCat(isExploded());
        }
    }

    public void drink(Double amount) {
        if (isExploded()) {
            System.out.println("Невозможно выполнить действие - кошка взорвалась.");
        } else {
            weight = weight + amount;
            foodEaten = foodEaten + amount;
            minusCat(isExploded());
        }
    }

    private void minusCat(boolean event) {
        if (event) {
            count--;
        }
    }

    public Double getWeight() {
        return weight;
    }

    private boolean isDead() {
        return weight < minWeight;
    }

    private boolean isExploded() {
        return weight > maxWeight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}