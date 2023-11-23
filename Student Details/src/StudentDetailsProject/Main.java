package StudentDetailsProject;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while(choice<=6){
            System.out.println("1.Create Database");
            System.out.println("2.Insert into Database");
            System.out.println("3.Retrieve the data from Database");
            System.out.println("4.Retrieve the data of particular Student");
            System.out.println("5.Delete the Database");
            System.out.println("6.Exit");
            System.out.println("Enter your choice :");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    CreateDatabase.createDatabase();
                    break;
                case 2:
                    InsertData.insertData();
                    break;
                case 3:
                    RetrieveData.retrieveData();
                    break;
                case 4:
                    RetrieveDataParticular.retriveParticular();
                case 5:
                    DeleteDatabase.deleteDatabase();
                    break;
                case 6:
                    exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
