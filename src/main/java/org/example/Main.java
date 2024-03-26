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

            switch (choice) {
                case 1:
                    db.createTable(connection, "Bobobo");
                    break;
                case 2:
                    db.readTable(connection,"artist");
                    break;
                case 3:
                    db.updateTable(connection, "song", "title", "Bobobo sound 2", 6 );
                    break;
                case 4:
                    db.deleteTable(connection, "Bobobo");
                    break;
                case 0:
                    // Выход из программы
                    System.out.println("Программа завершается.");
                    return;
                default:
                    System.out.println("Error. Try again");
            }
            System.out.println("12dwedewd3");
            System.out.println("12wdw3");
            System.out.println("123");
            System.out.println("1wdwedwe23");
            System.out.println("1wdwd23");
            System.out.println("123");
            System.out.println("123");
        }

    }
}