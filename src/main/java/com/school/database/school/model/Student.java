package com.school.database.school.model;

import java.util.Objects;

import com.school.database.school.enums.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

  private @Id @GeneratedValue Long id;
  @Column(nullable = false, unique = true)
  @NotBlank(message = "Username is mandatory")
  @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
  private String username;
  @Column(nullable = false)
  @NotBlank(message = "Password is mandatory")
  @Size(min = 4, message = "Password must be at least 4 characters")
  private String password;
  @Column(nullable = false, unique = true)
  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email should be valid")
  private String email;
  @Column(nullable = false)
  @NotBlank(message = "Name is mandatory")
  @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
  private String name;
  @Column(nullable = false)
  @NotBlank(message = "Major is mandatory")
  @Size(min = 2, max = 50, message = "Major must be between 2 and 50 characters")
  private String major;
  @Column(nullable = false)
  @NotNull
  @Min(value = 18, message = "Age must be at least 18")
  private int age;
  @Column(nullable = false)
  @NotNull
  @Enumerated(EnumType.STRING)
  private Grade grade;

  public Student() {

  }

  public Student(String username, String password, String email, String name, String major, int age, Grade grade) {
    setUsername(username);
    setPassword(password);
    setEmail(email);
    setName(name);
    setMajor(major);
    setAge(age);
    setGrade(grade);
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Student))
      return false;
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) && Objects.equals(this.name, student.name)
        && Objects.equals(this.major, student.major) && Objects.equals(this.age, student.age)
        && Objects.equals(this.username, student.username) && Objects.equals(this.password, student.password)
        && Objects.equals(this.email, student.email) && Objects.equals(this.grade, student.grade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.username, this.password, this.email, this.name, this.major, this.age, this.grade);
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + this.id + ",username=" + this.username + ",email=" + this.email + ", name='" + this.name
        + '\'' + ", major='" + this.major + '\''
        + ", age='"
        + this.age + ", grade='" + this.grade + '}';
  }
}
