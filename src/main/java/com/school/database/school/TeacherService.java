package com.school.database.school;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherService 
{
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository)
    {
        this.repository = repository;
    }

    public List<Teacher> getAllTeachers()
    {
        return repository.findAll();
    }

    public Teacher getTeacherById(Long id)
    {
        return repository.findById(id).orElseThrow(()-> new TeacherNotFoundException(id));
    }

    public 
}
