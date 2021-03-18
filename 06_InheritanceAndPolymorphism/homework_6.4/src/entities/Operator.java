package entities;

public class Operator implements Employee {

    public static final int OPERATOR_SALARY = 30_000;

    @Override
    public int getMonthSalary() {
        return OPERATOR_SALARY;
    }
}