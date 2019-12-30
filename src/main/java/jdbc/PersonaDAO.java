package jdbc;

import Persona.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

/*ESTA INTERFAZ ES EL DAO, ES QUIEN DEFINE LOS METODOS QUE COMUNICAN CON LA BD */

public interface PersonaDAO {

    public int insert(PersonaDTO persona) throws SQLException;

    public List<PersonaDTO> select() throws SQLException;
}
