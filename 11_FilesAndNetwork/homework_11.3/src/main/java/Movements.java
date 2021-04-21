import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    List<Operation> list;

    public Movements(String pathMovementsCsv) {
        list = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(pathMovementsCsv))) {
            List<String[]> lines = csvReader.readAll();

            for (int i = 1; i < lines.size(); i++) {
                createObject(lines.get(i));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void createObject(String[] line) {
        Operation operation = new Operation();

        operation.setIncome(Double.parseDouble(line[6].replaceAll(",", ".")));
        operation.setExpense(Double.parseDouble(line[7].replaceAll(",", ".")));

        list.add(operation);
    }

    public double getExpenseSum() {
        double expense = 0.0;

        for (Operation item : list) {
            expense += item.getExpense();
        }

        return expense;
    }

    public double getIncomeSum() {
        double income = 0.0;

        for (Operation item : list) {
            income += item.getIncome();
        }

        return income;
    }
}