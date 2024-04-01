package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException {

        FileInputStream fis;
        Properties property = new Properties();
        String host = null, login = null, password = null;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        DBFunctions db = new DBFunctions();
        Connection connection = db.connect_to_db(host, login, password);
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Main.class.getName());

        while (true) {
            System.out.println("Choose action:");
            System.out.println("0. Exit");
            System.out.println("1. Insert Table");
            System.out.println("2. Read Table");
            System.out.println("3. Update Table");
            System.out.println("4. Delete From Table");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String tableName;
            switch (choice) {
                case 1:
                    logger.info("Enter the table name you want to insert record: ");
                    tableName = scanner.nextLine();
                    logger.info("Enter columns you want to insert: ");
                    String columns = scanner.nextLine();
                    logger.info("Enter values you want to insert: ");
                    String values = scanner.nextLine();
                    db.insertTable(connection, tableName, columns, values);
                    break;
                case 2:
                    logger.info("Enter the table name you want to read: ");
                    tableName = scanner.nextLine();
                    db.readTable(connection, tableName);
                    break;
                case 3:
                    logger.info("Enter the table name you want to update: ");
                    tableName = scanner.nextLine();
                    logger.info("Enter the column name you want to update: ");
                    String columnName = scanner.nextLine();
                    logger.info("Enter the record id you want to update: ");
                    int recordId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    logger.info("Enter new value for the field: ");
                    String newValue = scanner.nextLine();
                    db.updateTable(connection, tableName, columnName, newValue, recordId);
                    break;
                case 4:
                    logger.info("Select the table you want to delete from: ");
                    tableName = scanner.nextLine();
                    logger.info("Enter the entry id you want to delete: ");
                    int entryId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    db.deleteFromTable(connection, tableName, entryId);
                    break;
                case 0:
                    // Выход из программы
                    logger.info("The program ends.");
                    return;
                default:
                    System.out.println("Error. Try again");
            }
        }
    }
}