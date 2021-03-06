package com.example.crud_app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// @CrossOrigin(origins = "http://localhost:8080")
@RestController
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/customPath")
    public Optional<Student> getStudent(
            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "surname", defaultValue = "") String surname
    ) {
        if (!id.equals("")) {
            var longId = Long.parseLong(id);
            if (longId != 0) {
                return studentRepository.findById(longId);
            }
        }

        if (!name.equals("") && !surname.equals("")) {
            return studentRepository.findByNameAndSurname(name, surname).stream().findFirst();
        }

        return studentRepository.findByNameOrSurname(name, surname).stream().findFirst();
    }
}
