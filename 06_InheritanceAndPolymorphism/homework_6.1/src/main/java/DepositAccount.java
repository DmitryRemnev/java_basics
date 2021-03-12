import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    @Override
    protected void put(double amountToPut) {

        if (super.canPut(amountToPut)) {
            super.put(amountToPut);
            lastIncome = LocalDate.now();
        }
    }

    @Override
    protected void take(double amountToTake) {

        if (canTake(amountToTake)) {
            super.take(amountToTake);
        }
    }

    @Override
    protected boolean canTake(double amountToTake) {
        return super.canTake(amountToTake) && hasMonthPassed();
    }

    private boolean hasMonthPassed() {
        return LocalDate.now().isAfter(lastIncome.plusMonths(1));
    }
}