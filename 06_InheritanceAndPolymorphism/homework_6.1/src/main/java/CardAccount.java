public class CardAccount extends BankAccount {

    public static final double ONE_PERCENT = 1.01;

    @Override
    public void take(double amountToTake) {

        if (amountToTake <= amount) {
            amount -= (amountToTake * ONE_PERCENT);
        }
    }
}