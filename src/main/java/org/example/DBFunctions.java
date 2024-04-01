package org.example;

import java.sql.*;

public class DBFunctions {
    public Connection connect_to_db(String dbname,String username,String password){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,username,password);
            if (connection != null){
                System.out.println("Connection established");
            }
            else{
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
    public void insertTable(Connection connection, String tableName, String columns, String values) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            String sql = "INSERT INTO " + tableName + "(" + columns + ")" + " VALUES (" + values + ")";
            statement.executeUpdate(sql);
            System.out.println("Record inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteFromTable(Connection connection, String tableName, int entryId) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            String sql = "DELETE FROM public." + tableName + " WHERE id = " + entryId;
            statement.executeUpdate(sql);
            System.out.println("Record deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void readTable(Connection connection, String table_name) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM " + table_name;
            ResultSet resultSet = statement.executeQuery(sql);

            // Получение метаданных результата запроса
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Обработка результатов запроса SELECT
            while (resultSet.next()) {
                // Обработка значений каждого столбца
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = resultSet.getObject(i);

                    // Вывод данных на консоль или выполнение нужных операций
                    System.out.println(columnName + ": " + value);
                }
            }

            // Закрытие ResultSet и Statement
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateTable(Connection connection, String table_name, String columnName, Object newValue, int recordId) {
        try {
            String sql = "UPDATE " + table_name + " SET " + columnName + " = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, newValue);
            statement.setInt(2, recordId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Параметр " + columnName + " успешно обновлен.");
            } else {
                System.out.println("Запись с указанным идентификатором не найдена.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
