package Persona;

/*ESTO VENDRIA A SER UN DTO (ES PRACTICAMENTE UN JAVABEAN) */
/*CLASE QUE TRANSFIERE INFORMACION ENTRE DIFERENTES CAPAS*/

import java.util.Objects;

public class PersonaDTO {
    public String name;
    public String email;
    public String direction;
    public int age;
    public int dni;

    public PersonaDTO(String name, String email, String direction, int age) {
        this.name = name;
        this.email = email;
        this.direction = direction;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", direction='" + direction + '\'' +
                ", age=" + age +
                ", dni=" + dni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaDTO that = (PersonaDTO) o;
        return age == that.age &&
                dni == that.dni &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, direction, age, dni);
    }
}
