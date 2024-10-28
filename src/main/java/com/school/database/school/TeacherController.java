package com.school.database.school;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/teachers")
public class TeacherController 
{
    private final TeacherService service;

    public TeacherController(TeacherService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getTeachers()
    {
        return service.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id)
    {
        return service.getTeacherById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveTeacher(@RequestBody @Valid Teacher newTeacher,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            Map<String,String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->{
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }

        Teacher savedTeacher = service.saveTeacher(newTeacher);

        return ResponseEntity.ok(savedTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@RequestBody @Valid Teacher newTeacher,BindingResult bindingResult, @PathVariable Long id)
    {
        if(bindingResult.hasErrors())
        {
            Map<String,String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->{
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }

        Teacher updatedTeacher = service.replaceTeacher(newTeacher, id);

        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id)
    {
        service.deleteTeacher(id);
    }
}
