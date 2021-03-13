public class CardAccount extends BankAccount {

    private static final double ONE_PERCENT = 1.01;

    @Override
    public void take(double amountToTake) {

        if (super.canTake(amountToTake * ONE_PERCENT)) {
            super.take(amountToTake * ONE_PERCENT);
        }
    }
}