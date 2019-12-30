import Persona.PersonaDTO;
import jdbc.PersonaDAO;
import jdbc.PersonaDAO_JDBC;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
    CUANDO SE TRABAJA CON TRANSACCIONES LAS OPERACIONES QUE AFECTAN EL ESTADO DE LA BD SON
    LAS MAS IMPORTANTES (INSERT,UPDATE,DELETE) SON SOBRE LAS QUE APLICAN LOS COMMITS Y ROLLBACK
 */

public class AplicationMain {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = ConnectionDB.getConnection();
            if(connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            /*SE USA LA INTERFAZ PersonaDAO PORQUE DEBE SER SIEMPRE LO MAS GENERICO POSIBLE */
            /*LA CLASE QUE LO IMPLEMENTA DEBE SER TRANSPARENTE AL MOMENTO DEL USO*/
            PersonaDAO personaDAOJDBC = new PersonaDAO_JDBC(connection);
            List<PersonaDTO> personas = null;

            /*SELECT*/
            personas = personaDAOJDBC.select();
            for(PersonaDTO it: personas){
                System.out.println(it.toString());
            }

            /*INSERT*/
            PersonaDTO p = new PersonaDTO("juan","gmail","calle1",21);
            personaDAOJDBC.insert(p);

            /*HACEMOS COMMIT PARA GUARDAR EFECTIVAMENTE LOS CAMBIOS EN LA BD*/
            /*IMPORTANTE RECORDAR QUE LOS COMMIT UNICAMENTE APLICAN PARA AQUELLAS TRANSACCIONES QUE
            * MODIFIQUEN EL ESTADO LA BASE DE DATOS (UPDATE,INSERT,DELETE) LOS SELECT NO AFECTAN EL ESTADO DE LA BD
            * */
            connection.commit();
            System.out.println("TRANSACCION EXITOSA");

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("TRANSACCION ROLLBACK");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
