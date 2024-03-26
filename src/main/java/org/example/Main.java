package org.example;

public class Main {
    public static void main(String[] args) {
        DBFunctions db = new DBFunctions();
        db.connect_to_db("DB_RECORDING_STUDIO", "localhost", "123");
    }
}