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

    public Teacher saveTeacher(Teacher newTeacher)
    {
        return repository.save(newTeacher);
    }

    public Teacher replaceTeacher(Teacher newTeacher,Long id)
    {
        return repository.findById(id)
        .map(teacher ->{
            teacher.setName(newTeacher.getName());
            teacher.setField(newTeacher.getField());
            teacher.setRole(newTeacher.getRole());
            return repository.save(teacher);
        })
        .orElseGet(() ->{
            return repository.save(newTeacher);
        });
    }

    public void deleteTeacher(Long id)
    {
        if(!repository.existsById(id))
        {
            throw new TeacherNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
