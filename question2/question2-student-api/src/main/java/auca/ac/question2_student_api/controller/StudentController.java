package auca.ac.question2_student_api.controller;   
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import auca.ac.question2_student_api.model.Student;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private List<Student>students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1L, "Manzi", "David", "david@gmail.com", "Computer Science", 3.5));
        students.add(new Student(2L, "Smith", "John", "smith@gmail.com", "Mathematics", 3.8));
        students.add(new Student(3L, "chris", "bruce", "bruce@gmail.com", "Physics", 3.2));
        students.add(new Student(4L, "Alice", "Kirezi", "alice@gmail.com","Information Technology", 3.9));
        students.add(new Student(5L, "Bob", "Johnson", "bob@gmail.com","Business Administration", 3.4));
        students.add(new Student(6L, "Eve", "Davis", "davis@gmail.com","software engineering", 3.6));
    }

    //get all the students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;

    }

    //get a student by id
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    //get students by theirr major
    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    //get students by their gpa
    @GetMapping("/gpa/{gpa}")
    public List<Student> getStudentsByGpa(@PathVariable Double gpa) {
        return students.stream()
                .filter(student -> student.getGpa() >= gpa)
                .collect(Collectors.toList());
    }

    //add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    //update a student
    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent){
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                s.setFirstname(updatedStudent.getFirstname());
                s.setLastname(updatedStudent.getLastname());
                s.setEmail(updatedStudent.getEmail());
                s.setMajor(updatedStudent.getMajor());
                s.setGpa(updatedStudent.getGpa());
                return s;
            }
        }
        return null;
    }

}
