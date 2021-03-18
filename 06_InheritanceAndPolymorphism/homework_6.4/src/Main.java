import Entities.Employee;

public class Main {
    public static final String RUB_ENDING = " руб.";

    public static void main(String[] args) {
        Company company = new Company(180, 80, 10, 55_000_000);
        company.hireAll();

        for (Employee employee : company.getTopSalaryStaff(10)) {
            System.out.println(employee.getMonthSalary() + RUB_ENDING);
        }
        System.out.println();

        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + RUB_ENDING);
        }
        System.out.println();

        company.fire();

        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary() + RUB_ENDING);
        }
        System.out.println();

        for (Employee employee : company.getLowestSalaryStaff(35)) {
            System.out.println(employee.getMonthSalary() + RUB_ENDING);
        }
    }
}