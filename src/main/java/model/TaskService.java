package model;

import database.DatabaseConnection;
import entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private String sql;

    public boolean addTask(String name, String description, int priority, String deadline) {
        this.sql = "INSERT INTO `tasks` (`name`, `description`, `priority`, `deadline`) VALUES (?, ?, ?, ?)";
        this.connection = DatabaseConnection.getConnection();

        try {
            assert this.connection != null;
            this.preparedStatement = connection.prepareStatement(sql);

            this.preparedStatement.setString(1, name);
            this.preparedStatement.setString(2, description);
            this.preparedStatement.setInt(3, priority);
            this.preparedStatement.setString(4, deadline);

            this.preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Task> getCurrentTaskList() {
        this.sql = "SELECT * FROM `tasks` WHERE `completed` LIKE 0";
        this.connection = DatabaseConnection.getConnection();

        try {
            assert connection != null;
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(sql);

            ArrayList<Task> list = new ArrayList<Task>();
            while (resultSet.next()) {
                String date = resultSet.getString("deadline");
                String[] dateArray;
                dateArray = date.split("-");
                String dateString = dateArray[2] + "." + dateArray[1] + "." + dateArray[0];

                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setPriority(resultSet.getInt("priority"));
                task.setDeadline(dateString);

                list.add(task);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
