package com.school.database.school.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.database.school.repository.StudentRepository;
import com.school.database.school.model.Student;

@Service
public class StudentDetailsService implements UserDetailsService {

    private final StudentRepository studentRepo;

    public StudentDetailsService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Student not found with username: " + username));
        UserDetails userDetails = User.builder()
                .username(student.getUsername())
                .password(student.getPassword())
                .roles("STUDENT")
                .build();

        return userDetails;
    }
}
