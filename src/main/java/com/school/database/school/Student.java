package com.school.database.school;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Student {

  private @Id
  @GeneratedValue Long id;
  //@NotNull
  //@Size(min=2, max=30)
  private String name;
  //@NotNull
  private String major;
  //@NotNull
  //@Min(18)
  private int age;

  Student() {}

  Student(String name, String major, int age) {

    this.name = name;
    this.major = major;
    this.age = age;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getMajor() {
    return this.major;
  }

  public int getAge()
  {
    return this.age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setmajortring(String major) {
    this.major = major;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Student))
      return false;
    Student employee = (Student) o;
    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
        && Objects.equals(this.major, employee.major);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.major);
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.major + '\'' + '}';
  }
}
