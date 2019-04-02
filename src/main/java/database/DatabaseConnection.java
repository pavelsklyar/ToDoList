package database;

import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:33060/ToDoList";
        String user = "homestead";
        String password = "secret";

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection, Statement statement) {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
