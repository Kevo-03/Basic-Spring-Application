package com.school.database.school;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Teacher 
{
    private @Id @GeneratedValue Long id;
    @NotBlank(message="Name is mandatory")
    @Size(min=2,max=30,message="Name must be between 2 and 30 characters")
    private String name;
    @NotBlank(message="Field is mandatory")
    @Size(min=2,max=30,message="Field must be between 2 and 30 characters")
    private String field;
    @NotBlank(message="Role is mandatory")
    private String role;

    public Teacher() {}

    public Teacher(String name, String field, String role)
    {
        setName(name);
        setField(field);
        setRole(role);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getName()
    {
        return name;
    }

    public String getField()
    {
        return field;
    }

    public String getRole()
    {
        return role;
    }

    @Override
  public boolean equals(Object o) 
  {

    if (this == o)
      return true;
    if (!(o instanceof Teacher))
      return false;
    Teacher teacher = (Teacher) o;
    return Objects.equals(this.id, teacher.id) && Objects.equals(this.name, teacher.name)
        && Objects.equals(this.field, teacher.field) && Objects.equals(this.role, teacher.role);
  }

  @Override
  public int hashCode() 
  {
    return Objects.hash(this.id, this.name, this.field,this.role);
  }

  @Override
  public String toString() 
  {
    return "Student{" + "id=" + this.id + ", name='" + this.name + '\'' + ", field='" + this.field + '\'' + ", role='" + this.role + '}';
  }
}
