package com.school.database.school.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super("Could not find teacher " + id);
    }

    public TeacherNotFoundException(String username) {
        super("Could not find teacher " + username);
    }
}
