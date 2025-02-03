package com.school.database.school.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.database.school.exception.StudentNotFoundException;
import com.school.database.school.model.Student;
import com.school.database.school.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final PasswordEncoder encoder;

    public StudentService(StudentRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student newStudent) {
        return repository.save(newStudent);
    }

    public Student regStudent(Student student) {
        student.setPassword(encoder.encode(student.getPassword()));
        return repository.save(student);
    }

    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student findStudentByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new StudentNotFoundException(username));
    }

    public Student replaceStudent(Student newStudent, Long id) {
        return repository.findById(id)
                .map(student -> {
                    student.setUsername(newStudent.getUsername());
                    student.setPassword(newStudent.getPassword());
                    student.setEmail(newStudent.getEmail());
                    student.setName(newStudent.getName());
                    student.setAge(newStudent.getAge());
                    student.setMajor(newStudent.getMajor());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    return repository.save(newStudent);
                });
    }

    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }

}