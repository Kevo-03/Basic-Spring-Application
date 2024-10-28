package com.school.database.school;

public class TeacherNotFoundException extends RuntimeException 
{
    public TeacherNotFoundException(Long id)
    {
        super("Could not find teacher" + id);
    }     
}
