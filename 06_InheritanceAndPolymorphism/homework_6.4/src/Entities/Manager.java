package Entities;

public class Manager implements Employee {

    private static final int FIXED_PART = 50_000;
    private static final double FIVE_PERCENT = 1.05;

    @Override
    public int getMonthSalary() {
        return (int) (FIXED_PART + (getMoneyForCompany() * FIVE_PERCENT));
    }

    private int getMoneyForCompany() {
        int min = 115_000;
        int max = 140_000;

        max -= min;

        return (int) ((Math.random() * ++max) + min);
    }
}