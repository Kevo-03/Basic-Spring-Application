package com.school.database.school.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teacher {
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
  @NotBlank(message = "Field is mandatory")
  @Size(min = 2, max = 30, message = "Field must be between 2 and 30 characters")
  private String field;
  @Column(nullable = false)
  @NotBlank(message = "Role is mandatory")
  private String role;

  public Teacher() {
  }

  public Teacher(String username, String password, String email, String name, String field, String role) {
    setUsername(username);
    setPassword(password);
    setEmail(email);
    setName(name);
    setField(field);
    setRole(role);
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Teacher))
      return false;
    Teacher teacher = (Teacher) o;
    return Objects.equals(this.id, teacher.id) && Objects.equals(this.name, teacher.name)
        && Objects.equals(this.field, teacher.field) && Objects.equals(this.role, teacher.role)
        && Objects.equals(this.username, teacher.username) && Objects.equals(this.password, teacher.password)
        && Objects.equals(this.email, teacher.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.username, this.password, this.email, this.name, this.field, this.role);
  }

  @Override
  public String toString() {
    return "Teacher{" + "id=" + this.id + ",username=" + this.username + ",email=" + this.email + ", name='" + this.name
        + '\'' + ", field='" + this.field + '\'' + ", role='"
        + this.role + '}';
  }
}
