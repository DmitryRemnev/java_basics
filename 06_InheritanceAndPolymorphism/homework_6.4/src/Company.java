import java.util.ArrayList;
import java.util.List;

public class Company {

    public final List<Employee> employees = new ArrayList<>();
    private final int operators;
    private final int managers;
    private final int topManagers;
    private final double income;

    public Company(int operators, int managers, int topManagers, double income) {
        this.operators = operators;
        this.managers = managers;
        this.topManagers = topManagers;
        this.income = income;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll() {
        for (int i = 0; i < operators; i++) {
            hire(new Operator());
        }

        for (int i = 0; i < managers; i++) {
            hire(new Manager());
        }

        for (int i = 0; i < topManagers; i++) {
            hire(new TopManager(getIncome()));
        }
    }

    public void fire() {

        for (int i = 0; i < employees.size(); i++) {

            if (i % 2 == 0) {
                employees.remove(i);
            }
        }
    }

    public double getIncome() {
        return income;
    }

    List<Employee> getTopSalaryStaff(int count) {
        employees.sort(new TopComparator());
        List<Employee> list = new ArrayList<>();

        if (isValidCount(count)) {

            for (int i = 0; i < count; i++) {
                list.add(employees.get(i));
            }
        }

        return list;
    }

    List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(new LowestComparator());
        List<Employee> list = new ArrayList<>();

        if (isValidCount(count)) {

            for (int i = 0; i < count; i++) {
                list.add(employees.get(i));
            }
        }

        return list;
    }

    private boolean isValidCount(int count) {
        return count > 0 && count <= employees.size();
    }
}