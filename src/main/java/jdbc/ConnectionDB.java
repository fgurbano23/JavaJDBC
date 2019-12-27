package jdbc;

import java.sql.*;

public class ConnectionDB {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/persona?useSSL=false&serverTimezone=UTC";
    public static final String JDB_USER = "furbano";
    public static final String JDBC_PASS = "fu082018";

    public static final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL,JDB_USER,JDBC_PASS);
    }

    public static void close (Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }


    public static void close (PreparedStatement preparedStatement){
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }


    public static void close (ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }


}
