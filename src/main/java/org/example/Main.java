package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBFunctions db = new DBFunctions();
        Connection connection = db.connect_to_db("DB_RECORDING_STUDIO", "postgres", "123");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose action:");
            System.out.println("0. Exit");
            System.out.println("1. Create Table");
            System.out.println("2. Read Table");
            System.out.println("3. Update Table");
            System.out.println("4. Delete Table");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String tableName;
            switch (choice) {
                case 1:
                    System.out.println("Enter the table name you want to create: ");
                    tableName = scanner.nextLine();
                    db.createTable(connection, tableName);
                    break;
                case 2:
                    System.out.println("Enter the table name you want to read: ");
                    tableName = scanner.nextLine();
                    db.readTable(connection, tableName);
                    break;
                case 3:
                    System.out.println("Enter the table name you want to update: ");
                    tableName = scanner.nextLine();
                    System.out.println("Enter the column name you want to update: ");
                    String columnName = scanner.nextLine();
                    System.out.println("Enter the record id you want to update: ");
                    int recordId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter new value for the field: ");
                    String newValue = scanner.nextLine();
                    db.updateTable(connection, tableName, columnName, newValue, recordId);
                    break;
                case 4:
                    System.out.println("Enter table name you want to delete: ");
                    tableName = scanner.nextLine();
                    db.deleteTable(connection, tableName);
                    break;
                case 0:
                    // Выход из программы
                    System.out.println("The program ends.");
                    return;
                default:
                    System.out.println("Error. Try again");
            }
        }
    }
}