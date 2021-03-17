public class TopManager implements Employee {

    private static final int GOOD_COMPANY_INCOME = 10_000_000;
    private static final int FIXED_PART = 100_000;
    private static final double BONUS_COEFFICIENT = 2.5;
    double companyIncome;

    public TopManager(double companyIncome) {
        this.companyIncome = companyIncome;
    }

    @Override
    public int getMonthSalary() {

        if (companyIncome > GOOD_COMPANY_INCOME) {
            return (int) (FIXED_PART * BONUS_COEFFICIENT);

        } else {
            return FIXED_PART;
        }
    }
}