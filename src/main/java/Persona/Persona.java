package Persona;

public class Persona {
    public String name;
    public String email;
    public String direction;
    public int age;
    public int dni;

    public Persona(String name, String email, String direction, int age) {
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
}
