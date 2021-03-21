import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        sortBySalaryAndAlphabet(staff);

        for (Employee item : staff) {
            System.out.println(item.toString());
        }
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((o1, o2) -> {
            if (o1.getSalary() > o2.getSalary()) {
                return 1;
            } else if (o1.getSalary() < o2.getSalary()) {
                return -1;
            } else {
                return o1.toString().compareTo(o2.getName());
            }
        });
    }
}