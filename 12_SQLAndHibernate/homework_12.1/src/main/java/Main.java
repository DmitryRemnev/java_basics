import java.sql.*;

public class Main {
    public static final String SQL_QUERY = "SELECT course_name, COUNT(pl.subscription_date) / (MAX(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date)) + 1) AS range_months FROM PurchaseList pl GROUP BY course_name;";
    public static final String URL = "jdbc:mysql://localhost:3306/skillbox";
    public static final String USER = "root";
    public static final String PASS = "Tgb10Ujm73";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_QUERY)) {

            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(resultSet.getString("course_name"));
                stringBuilder.append(" ");
                stringBuilder.append(resultSet.getString("range_months"));

                System.out.println(stringBuilder);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}