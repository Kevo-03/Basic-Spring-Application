package com.school.database.school.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }

    public StudentNotFoundException(String username) {
        super("Could not find student " + username);
    }
}
