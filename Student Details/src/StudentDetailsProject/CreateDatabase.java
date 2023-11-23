package StudentDetailsProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

    public static void createDatabase() {
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Sricharan123*";
        String dbName = "testdatabase";
        String tableName = "Students";

        try {

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            String createDatabaseSQL = "CREATE DATABASE " + dbName;
            statement.executeUpdate(createDatabaseSQL);
            String useDataBase = "USE "+dbName;
            statement.executeUpdate(useDataBase);
            String createTable = "CREATE TABLE "+tableName+" (stId int, stName varchar(25), stRollno int);";
            statement.executeUpdate(createTable);

            System.out.println("Database '" + dbName + "' has been created successfully.");
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

