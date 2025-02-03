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
import com.school.database.school.model.Teacher;
import com.school.database.school.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return service.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return service.getTeacherById(id);
    }

    @GetMapping("/profile")
    public ResponseEntity<Teacher> getProfile(Authentication authentication) {
        String username = authentication.getName();
        Teacher teacher = service.getTeacherByUsername(username);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping
    public Teacher saveTeacher(@RequestBody @Valid Teacher newTeacher) {
        return service.saveTeacher(newTeacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody @Valid Teacher newTeacher, @PathVariable Long id) {
        return service.replaceTeacher(newTeacher, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        service.deleteTeacher(id);
    }
}
