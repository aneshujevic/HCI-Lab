package com.example.crud_app.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {
    public static ArrayList<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Lewis", "Carrol", "F", "EL"));
        students.add(new Student(5, "John", "Travolta", "M", "SI"));
        students.add(new Student(2, "John", "Doe", "M", "SI"));
        students.add(new Student(15, "Alice", "Wonderland", "F", "SI"));
        students.add(new Student(10, "Bob", "Trudier", "M", "SI"));
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @GetMapping("/student")
    public Optional<Student> getStudent(
            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "surname", defaultValue = "") String surname
    ) {
        if (!id.equals("")) {
            var longId = Long.parseLong(id);
            if (longId != 0) {
                return students.stream()
                        .filter(x -> x.getId() == longId)
                        .findFirst();
            }
        }

        if (!name.equals("") && !surname.equals("")) {
            return students.stream()
                    .filter(x -> x.getName().equals(name) && x.getSurname().equals(surname))
                    .findFirst();
        }

        return students.stream()
                .filter(x -> x.getName().equals(name) ||
                        x.getSurname().equals(surname))
                .findFirst();
    }

    @PostMapping("/student")
    public
    Message newStudent(@RequestBody Student student) {
        students.add(student);
        return new Message("Student created successfully");
    }

    @DeleteMapping("/student")
    public Message deleteStudent(@RequestParam(value = "id", defaultValue = "") String id) {
        if (!id.equals("")) {
            var longId = Long.parseLong(id);
            if (longId != 0) {
                students.removeIf(x -> x.getId() == longId);
                return new Message("Successfully deleted student!");
            }
        }

        return new Message("No such student found");
    }

    @PutMapping("/student")
    public Message updateStudent(@RequestBody Student reqStudent) {
        var student = students.stream()
                .filter(x -> x.getId() == reqStudent.getId())
                .findFirst();

        if (student.isPresent()) {
            var studentFound = student.get();
            studentFound.setDepartment(reqStudent.getDepartment());
            studentFound.setGender(reqStudent.getGender());
            studentFound.setName(reqStudent.getName());
            studentFound.setSurname(reqStudent.getSurname());
        }

        return new Message("Successfully updated a student.");
    }
}
