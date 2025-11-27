package cursoSpringBoot.domain;

/**
 * Clase que representa una instancia de un alumno
 * @author victorfer69
 */
public class Student {

    // Atributos de la clase alumno
    private int id;
    private String name;
    private String email;
    private int age;
    private String course;

    /**
     * Este es el constructor de la clase alumno
     * @param id
     * @param name
     * @param email
     * @param age
     * @param course
     */
    public Student(int id, String name, String email, int age, String course) {
        setId(id);
        setName(name);
        setEmail(email);
        setAge(age);
        setCourse(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
