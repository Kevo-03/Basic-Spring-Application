package com.school.database.school;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
    private final StudentRepository repository;
    
    StudentController(StudentRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<Student> all()
    {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) 
    {
        return repository.save(newStudent);
    }

    @GetMapping("/students/{id}")
    Student one(@PathVariable Long id)
    {
        return repository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) 
    {
        repository.deleteById(id);
  }
}
