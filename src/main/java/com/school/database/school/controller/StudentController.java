
package com.school.database.school.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.database.school.model.Student;
import com.school.database.school.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> all() {
        return service.getStudents();
    }

    @PostMapping
    public Student newStudent(@RequestBody @Valid Student newStudent) {
        return service.saveStudent(newStudent);
    }

    @GetMapping("/{id}")
    public Student findStudent(@PathVariable Long id) {
        return service.findStudentById(id);
    }

    @GetMapping("/profile")
    public ResponseEntity<Student> getProfile(Authentication authentication) {
        String username = authentication.getName();
        Student student = service.findStudentByUsername(username);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody @Valid Student newStudent, @PathVariable Long id) {
        return service.replaceStudent(newStudent, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}