package com.school.database.school.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.database.school.repository.StudentRepository;
import com.school.database.school.repository.TeacherRepository;
import com.school.database.school.Security.CustomUserDetails;
import com.school.database.school.model.Student;
import com.school.database.school.model.Teacher;

@Service
public class CustomDetailsService implements UserDetailsService {

    private final StudentRepository studentRepo;
    private final TeacherRepository teacherRepository;

    public CustomDetailsService(StudentRepository studentRepo, TeacherRepository teacherRepository) {
        this.studentRepo = studentRepo;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByUsername(username).orElse(null);
        if (student != null) {
            return new CustomUserDetails(student);
        }

        // If not found, try to find a teacher by username
        Teacher teacher = teacherRepository.findByUsername(username).orElse(null);
        if (teacher != null) {
            return new CustomUserDetails(teacher);
        }

        // If no user is found, throw exception
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
