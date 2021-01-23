
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodEaten;

    private static int count = 0;

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

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMinWeight() {
        return minWeight;
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
        return (weight >= minWeight && weight <= maxWeight);
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