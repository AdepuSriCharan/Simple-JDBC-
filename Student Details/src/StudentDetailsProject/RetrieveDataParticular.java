package StudentDetailsProject;

import java.sql.*;
import java.util.Scanner;

public class RetrieveDataParticular {
    public static void retriveParticular() {
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
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the Roll.No");
            int targetStudentRollno = input.nextInt();
            String selectParticularDataSQL = "SELECT * FROM "+tableName+" WHERE stRollno = ?";
            PreparedStatement selectParticularDataStatement = connection.prepareStatement(selectParticularDataSQL);

            selectParticularDataStatement.setInt(1,targetStudentRollno);
            ResultSet resultSet = selectParticularDataStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("stId");
                String name = resultSet.getString("stName");
                int rollno = resultSet.getInt("stRollno");

                System.out.println("ID: " + id + ", Name: " + name + ", Roll.NO: " + rollno);
            } else {
                System.out.println("No Student Found with "+targetStudentRollno);
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
