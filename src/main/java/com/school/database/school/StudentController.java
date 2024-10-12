package com.school.database.school;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    Student newStudent(@RequestBody Student newStudent) 
    {
        return service.saveStudent(newStudent);
    }

    @GetMapping("/{id}")
    Student one(@PathVariable Long id)
    {
        return service.findStudentById(id);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) 
    {
        service.deleteStudent(id);
    }
}
