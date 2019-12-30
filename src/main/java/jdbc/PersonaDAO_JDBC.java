package jdbc;

import Persona.PersonaDTO;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*ESTO VENDRIA A SER LA IMPLEMENTACION DEL DAO A TRAVÉS DE JDBC*/
/*DEFINE LOS ACCESOS A LA BASES DE DATOS*/

public class PersonaDAO_JDBC implements PersonaDAO{

    public Connection connectionTransaccional;

    public static final String SQL_SELECT = "SELECT * FROM PERSON";
    public static final String SQL_INSERT = "INSERT INTO PERSON(NOMBRE,EMAIL,DIRECCION,EDAD) VALUES(?,?,?,?)";

    public PersonaDAO_JDBC(){

    }

    public PersonaDAO_JDBC(Connection conexion){
        this.connectionTransaccional = conexion;
    }

    public List<PersonaDTO> select() throws SQLException {
        Connection connection = (this.connectionTransaccional != null ) ? this.connectionTransaccional : ConnectionDB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<PersonaDTO> response = new ArrayList<PersonaDTO>();
        try {
            connection = ConnectionDB.getConnection();
            preparedStatement =connection.prepareStatement(SQL_SELECT);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                PersonaDTO persona = new PersonaDTO(
                   rs.getString("NOMBRE"),
                   rs.getString("EMAIL"),
                   rs.getString("EMAIL"),
                   rs.getInt("EDAD")
                );
                response.add(persona);
            }
        } finally {
            ConnectionDB.close(rs);
            ConnectionDB.close(preparedStatement);
            if(this.connectionTransaccional == null){
                ConnectionDB.close(connection);
            }

        }
        return response;
    }


    public int insert(PersonaDTO persona) throws SQLException{
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        int response = 0;
        try {
            connection = (this.connectionTransaccional != null ) ? this.connectionTransaccional : ConnectionDB.getConnection();
            preparedStatement =  connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1,persona.getName());
            preparedStatement.setString(2,persona.getEmail());
            preparedStatement.setString(3,persona.getDirection());
            preparedStatement.setInt(4,persona.getAge());
            response = preparedStatement.executeUpdate();
        } finally {
            ConnectionDB.close(preparedStatement);
            if(this.connectionTransaccional == null){
                ConnectionDB.close(connection);
            }

        }
        return response;
    }

}
