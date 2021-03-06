public class BankAccount {

    protected double amount;

    protected double getAmount() {
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

    public boolean send(BankAccount receiver, double amount) {

        if (canTake(amount) && receiver.canPut(amount)) {
            take(amount);
            receiver.put(amount);
            return true;

        } else {
            return false;
        }
    }

    protected boolean canPut(double amountToPut) {
        return amountToPut > 0;
    }

    protected boolean canTake(double amountToTake) {
        return amountToTake > 0 && amountToTake <= amount;
    }
}