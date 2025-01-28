package com.school.database.school.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.school.database.school.Security.JwtUtils;
import com.school.database.school.model.Student;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final StudentService studentService;
    private final JwtUtils jwtUtils;

    public AuthService(AuthenticationManager authenticationManager, StudentService studentService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.studentService = studentService;
        this.jwtUtils = jwtUtils;
    }

    public Student register(Student student) {
        return studentService.regStudent(student);
    }

    public String login(String username, String password) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String token = jwtUtils.generateToken(authentication);
        return token;
    }
}
