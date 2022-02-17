package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name length should be between 2 and 20")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "Min age is 0")
    @Max(value = 100, message = "Max age is 100")
    private int age;

    @Column(name = "username")
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 20, message = "Name length should be between 2 and 20")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 1, max = 5, message = "Name length should be between 1 and 5")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {}

    public User(String firstName, int age) {
        this.name = firstName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
}
