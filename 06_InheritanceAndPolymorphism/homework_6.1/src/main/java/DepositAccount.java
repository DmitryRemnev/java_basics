import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    LocalDate lastIncome;

    public void put(double amountToPut) {

        if (amountToPut >= 0) {
            amount += amountToPut;
            lastIncome = LocalDate.now();
        }
    }

    @Override
    public void take(double amountToTake) {

        LocalDate now = LocalDate.now();

        if (hasMonthPassed(now)) {
            if (amountToTake <= amount) {
                amount -= amountToTake;
            }
        }
    }

    private boolean hasMonthPassed(LocalDate now) {
        return now.isAfter(lastIncome.plusMonths(1));
    }
}