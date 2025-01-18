package com.school.database.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.database.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
