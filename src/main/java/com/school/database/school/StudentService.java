package com.school.database.school;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService 
{
    private final StudentRepository repository;

    public StudentService(StudentRepository repository)
    {
        this.repository = repository;
    }

    public List<Student> getStudents()
    {
        return repository.findAll();
    }

    public Student saveStudent(Student newStudent)
    {
        return repository.save(newStudent);
    }

    public Student findStudentById(Long id) 
    {
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student replaceStudent(Student newStudent, Long id)
    {
        return repository.findById(id)
        .map(student -> {
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            student.setMajor(newStudent.getMajor());
            return repository.save(student);
        })
        .orElseGet(() -> {
            return repository.save(newStudent);
        });
    }

    public void deleteStudent(Long id)
    {
        if(!repository.existsById(id))
        {
            throw new StudentNotFoundException(id);
        }
        repository.deleteById(id);
    }
    
}