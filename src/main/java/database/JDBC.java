package database;

import com.mysql.cj.MysqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:33060/ToDoList";
        String user = "homestead";
        String password = "secret";
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

            long time = System.currentTimeMillis();

            connection.setAutoCommit(false);
            String sql = "INSERT INTO USERS (NAME, GENDER, ADDRESS) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setString(1, "NoName_"+i);
                preparedStatement.setString(2, "Male"+i);
                preparedStatement.setString(3, "192.168.1."+i);
                preparedStatement.addBatch();
            }
            /*int[] res = */preparedStatement.executeBatch();
            connection.commit();

            System.out.println(System.currentTimeMillis()-time);
//            System.out.println(res);


//            String sql = "SELECT * FROM USERS;";
//            st = connection.createStatement();
//            rs = st.executeQuery(sql);
//            List<String> list = new ArrayList<String>();
//            while (rs.next()){
//                list.add(rs.getString("name"));
//            }
//            System.out.println(list);


            /*String sql = "INSERT INTO USERS (NAME, GENDER, ADDRESS) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Dasha");
            preparedStatement.setString(2, "Fem");
            preparedStatement.setString(3, "192.168.1.3");
            System.out.println(preparedStatement.executeUpdate());
*/
//            ResultSet rs = st.executeQuery(sql);
            /*String sql = "CREATE TABLE IF NOT EXISTS USERS(" +
                    "ID INT AUTO_INCREMENT," +
                    " NAME VARCHAR(255)," +
                    " GENDER VARCHAR(255)," +
                    " ADDRESS VARCHAR(255)," +
                    " PRIMARY KEY (ID));";
            st = connection.createStatement();
            st.execute(sql);*/


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}