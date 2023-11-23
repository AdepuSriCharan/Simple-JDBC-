package StudentDetailsProject;

import java.sql.*;

public class RetrieveData {

    public static void retrieveData() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "testdatabase";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Sricharan123*";
        String tableName = "Students";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url + dbName, userName, password);

//            Statement statement = connection.createStatement();
//            String createDatabaseSQL = "USE " + dbName;
//            statement.executeUpdate(createDatabaseSQL);

            String selectDataSQL = "SELECT * FROM "+tableName;
            PreparedStatement selectDataStatement = connection.prepareStatement(selectDataSQL);
            ResultSet resultSet = selectDataStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("stId");
                String name = resultSet.getString("stName");
                int rollno = resultSet.getInt("stRollno");

                System.out.println("ID: " + id + ", Name: " + name + ", Roll.NO: " + rollno);
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

