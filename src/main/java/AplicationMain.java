import Persona.Persona;
import Persona.PersonaJDBC;

import java.util.List;

public class AplicationMain {
    public static void main(String[] args) {
        List<Persona> personas = PersonaJDBC.getPersonas();
        for(Persona it: personas){
            System.out.println(it.toString());
        }
        Persona p = new Persona("juan","gmail","calle1",21);
        PersonaJDBC.insert(p);
    }
}
