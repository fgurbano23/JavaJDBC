package jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

/*MANEJA Y CREA EL POOL DE CONEXIONES ATRAVES DE LA LIBRERIA APACHE COMMONS*/

public class ConnectionDB {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/persona?useSSL=false&serverTimezone=UTC";
    public static final String JDB_USER = "furbano";
    public static final String JDBC_PASS = "fu082018";

    /*SE CONFIGURA EL POOL DE CONEXIONES Y LA CONEXION POR DEFAULT*/
    public static DataSource getDataSource(){
        /*HACEMOS USO DE LA CLASE BasicDataSource DE APACHE COMMONS*/
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDB_USER);
        dataSource.setPassword(JDBC_PASS);
        /*DEFINIMOS EL TAMAÑO DEL POOL DE CONEXIONES (CONEXIONES POR DEFECTO) EN ESTE CASO DE TAMAÑO 5*/
        dataSource.setInitialSize(5);
        return  dataSource;
    }

    public static final Connection getConnection() throws SQLException {
       /*
            DriverManager PERMITE CREAR UNA UNICA CONEXION A LA BD.
            SIN EMBARGO EN ESTE CASO MANEJAREMOS LAS CONEXIONES CON UN POOL DE CONEXIONES.
                return DriverManager.getConnection(JDBC_URL,JDB_USER,JDBC_PASS);
       */

        return getDataSource().getConnection();
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
