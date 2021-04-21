public class Main {
    private static final String DATA_FILE = "src/main/resources/movementList.csv";
    private static final String SUM_EXPENSE = "Сумма расходов: ";
    private static final String SUM_INCOME = "Сумма доходов: ";
    private static final String RUB = " руб.";

    public static void main(String[] args) {
        Movements movements = new Movements(DATA_FILE);

        System.out.println(SUM_EXPENSE + movements.getExpenseSum() + RUB);
        System.out.println(SUM_INCOME + movements.getIncomeSum() + RUB);
    }
}