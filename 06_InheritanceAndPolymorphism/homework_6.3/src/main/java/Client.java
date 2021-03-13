public abstract class Client {
    protected double amount;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {

        if (canPut(amountToPut)) {
            amount += amountToPut;
        }
    }

    public void take(double amountToTake) {

        if (canTake(amountToTake)) {
            amount -= amountToTake;
        }
    }

    protected boolean canPut(double amountToPut) {
        return amountToPut > 0;
    }

    protected boolean canTake(double amountToTake) {
        return amountToTake > 0 && amountToTake <= amount;
    }
}