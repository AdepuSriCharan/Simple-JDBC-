package StudentDetailsProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertData {

    public static void insertData() {

        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Sricharan123*";
        String dbName = "testdatabase";
        String tableName = "Students";

        List<Student> studentList = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID of Student :");
        int stId = input.nextInt();
        input.nextLine();
        System.out.println("Enter the Name of Student :");
        String stName = input.nextLine();
        System.out.println("Enter the Roll.No of the Student :");
        int stRollno = input.nextInt();
        input.nextLine();

        studentList.add(new Student(stId, stName, stRollno));
        //studentList.add(new Student(3, "apple", 564));

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url + dbName, userName, password);

            String insertDataSQL = "INSERT INTO " + tableName + " (stId, stName, stRollno) VALUES (?, ?, ?)";
            PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL);

            for (Student student : studentList) {
                insertDataStatement.setInt(1, student.getStId());
                insertDataStatement.setString(2, student.getStName());
                insertDataStatement.setInt(3, student.getStRollno());

                int rowsInserted = insertDataStatement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Data for student " + student.getStName() + " inserted successfully.");
                } else {
                    System.out.println("No data inserted for student " + student.getStName());
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

// Student class to represent student data
class Student {
    private final int stId;
    private final String stName;
    private final int stRollno;

    public Student(int stId, String stName, int stRollno) {
        this.stId = stId;
        this.stName = stName;
        this.stRollno = stRollno;
    }

    public int getStId() {
        return stId;
    }

    public String getStName() {
        return stName;
    }

    public int getStRollno() {
        return stRollno;
    }
}
