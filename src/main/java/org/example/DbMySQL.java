package org.example;

import java.sql.*;

public class DbMySQL
{
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/book_db?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String args[]) {
        String query = "SELECT * FROM books";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                System.out.printf("id: %d, name: %s, author: %s %n", id, name, author);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}