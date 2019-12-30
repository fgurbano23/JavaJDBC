import Persona.Persona;
import Persona.PersonaJDBC;
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
            PersonaJDBC personaJDBC = new PersonaJDBC(connection);
            List<Persona> personas = null;

            /*SELECT*/
            personas = personaJDBC.getPersonas();
            for(Persona it: personas){
                System.out.println(it.toString());
            }

            /*INSERT*/
            Persona p = new Persona("juan","gmail","calle1",21);
            personaJDBC.insert(p);

            /*HACEMOS COMMIT PARA GUARDAR EFECTIVAMENTE LOS CAMBIOS EN LA BD*/
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("HACIENDO ROLLBACK");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
