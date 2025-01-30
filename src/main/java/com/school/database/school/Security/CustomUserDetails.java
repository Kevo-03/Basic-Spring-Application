package com.school.database.school.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.school.database.school.model.Student;
import com.school.database.school.model.Teacher;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CustomUserDetails implements UserDetails {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    public static CustomUserDetails build(Student student) {
        return new CustomUserDetails(
                student.getId(),
                student.getUsername(),
                student.getEmail(),
                student.getPassword(),
                "STUDENT");
    }

    public static CustomUserDetails build(Teacher teacher) {
        return new CustomUserDetails(
                teacher.getId(),
                teacher.getUsername(),
                teacher.getEmail(),
                teacher.getPassword(),
                "TEACHER");
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomUserDetails custom = (CustomUserDetails) o;
        return Objects.equals(id, custom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
