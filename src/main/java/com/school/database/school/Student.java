package com.school.database.school;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
class Student {

  private @Id
  @GeneratedValue Long id;
  @NotBlank(message = "Name is mandatory")
  @Size(min=2, max=30,message = "Name must be between 2 and 30 characters")
  private String name;
  @NotBlank(message = "Major is mandatory")
  @Size(min = 2, max = 50, message = "Major must be between 2 and 50 characters")
  private String major;
  @NotNull
  @Min(18)
  private int age;

  public Student() 
  {

  }

  public Student(String name, String major, int age) 
  {

    this.name = name;
    this.major = major;
    this.age = age;
  }

  public Long getId() 
  {
    return this.id;
  }

  public String getName() 
  {
    return this.name;
  }

  public String getMajor() 
  {
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

  public void setId(Long id) 
  {
    this.id = id;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  public void setMajor(String major) 
  {
    this.major = major;
  }

  @Override
  public boolean equals(Object o) 
  {

    if (this == o)
      return true;
    if (!(o instanceof Student))
      return false;
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) && Objects.equals(this.name, student.name)
        && Objects.equals(this.major, student.major) && Objects.equals(this.age, student.age);
  }

  @Override
  public int hashCode() 
  {
    return Objects.hash(this.id, this.name, this.major,this.age);
  }

  @Override
  public String toString() 
  {
    return "Student{" + "id=" + this.id + ", name='" + this.name + '\'' + ", major='" + this.major + '\'' + ", age='" + this.age + '}';
  }
}
