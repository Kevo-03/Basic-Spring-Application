package com.school.database.school;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController 
{
    private final StudentService service;
    
    StudentController(StudentService service)
    {
        this.service = service;
    }

    @GetMapping
    List<Student> all()
    {
        return service.getStudents();
    }

    @PostMapping
    public ResponseEntity<Student> newStudent(@RequestBody @Valid Student newStudent, BindingResult bindingResult) 
    {
        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body(null);
        }

        Student savedStudent = service.saveStudent(newStudent);

        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/{id}")
    Student one(@PathVariable Long id)
    {
        return service.findStudentById(id);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody @Valid Student newStudent, BindingResult bindingResult, @PathVariable Long id) 
    {
        if (bindingResult.hasErrors()) 
        {
            return ResponseEntity.badRequest().body(null);
        }
        Student updatedStudent = service.replaceStudent(newStudent, id);

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) 
    {
        service.deleteStudent(id);
    }
}
