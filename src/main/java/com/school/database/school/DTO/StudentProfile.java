package com.school.database.school.DTO;

import com.school.database.school.enums.Grade;

import lombok.Data;

@Data
public class StudentProfile {

    private String name;
    private String username;
    private String major;
    private String email;
    private Grade grade;

    public StudentProfile(String name, String username, String major, String email, Grade grade) {
        setName(name);
        setUsername(username);
        setMajor(major);
        setEmail(email);
        setGrade(grade);
    }
}
