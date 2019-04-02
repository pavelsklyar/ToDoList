package database.tables;

import database.DatabaseConnection;
import model.User;

import java.sql.*;

public class Users {

    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private static Connection connection;
    private static String sql;

    public static User getUserByEmail(String email) {
        sql = "SELECT * FROM `users` WHERE `email` = '" + email + "'";
        connection = DatabaseConnection.getConnection();

        try {
            assert connection != null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();

            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setSalt(resultSet.getString("salt"));

            DatabaseConnection.closeConnection(connection, statement);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static boolean setNewUser(String email, String password, String salt) {
        sql = "INSERT INTO `users` (`email`, `password`, `salt`) VALUES (?, ?, ?)";
        connection = DatabaseConnection.getConnection();

        try {
            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, salt);

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
