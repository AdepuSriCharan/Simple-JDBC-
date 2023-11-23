package StudentDetailsProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDatabase {

    public static void deleteDatabase() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "testdatabase";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Sricharan123*";

        try {
            // Register the JDBC driver
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            String dropDatabaseSQL = "DROP DATABASE " + dbName;
            statement.executeUpdate(dropDatabaseSQL);

            System.out.println("Database '" + dbName + "' has been deleted successfully.");
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

