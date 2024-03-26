package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBFunctions db = new DBFunctions();
        Connection connection = db.connect_to_db("DB_RECORDING_STUDIO", "postgres", "123");
        //db.createTable(connection, "Bobobo");
        //db.readTable(connection,"artist");
        //db.updateTable(connection, "song", "title", "Bobobo sound", 6 );
    }
}