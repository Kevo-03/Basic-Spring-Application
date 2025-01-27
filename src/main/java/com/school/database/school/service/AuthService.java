package com.school.database.school.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.school.database.school.model.Student;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final StudentService studentService;

    public AuthService(AuthenticationManager authenticationManager, StudentService studentService) {
        this.authenticationManager = authenticationManager;
        this.studentService = studentService;
    }

    public Student register(Student student) {
        return studentService.regStudent(student);
    }

    public void login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
