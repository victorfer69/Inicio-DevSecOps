package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/alumnos")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Pedro Fernandez", "pedro@gmail.com", 21, "Ingenieria Informatica"),
            new Student(2, "Francisco Lopez", "paco@gmail.com", 21, "Ingenieria Mecanica"),
            new Student(3, "Juan Martinez", "juan@gmail.com", 21, "Ingenieria Electronica"),
            new Student(4, "Ana Cruz", "ana@gmail.com", 21, "Ingenieria Industrial")
    ));

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAlumnos(){
        return students;
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Student getAlumnoByEmail(@PathVariable String email){
        for(Student s : students){
            if(s.getEmail().equalsIgnoreCase(email)){
                return s;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student postAlumno(@RequestBody Student student){
        for(Student s : students){
            if(s.getId() == student.getId()){
                return null;
            }
        }
        students.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Student putAlumno(@RequestBody Student student){
        for(Student s : students){
            if(s.getId() == student.getId()){
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());
                return s;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public Student pathAlumno(@RequestBody Student student){
        for(Student s : students){
            if(s.getId() == student.getId()){
                if (student.getName() != null) {
                    s.setName(student.getName());
                }
                if (student.getEmail() != null) {
                    s.setEmail(student.getEmail());
                }
                if (student.getAge() != 0) {
                    s.setAge(student.getAge());;
                }
                if (student.getName() != null) {
                    s.setCourse(student.getCourse());
                }
                return s;
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Student deleteAlumno(@PathVariable int id){
        for(Student s : students){
            if(s.getId() == id){
                students.remove(s);
                return s;
            }
        }
        return null;
    }

}
