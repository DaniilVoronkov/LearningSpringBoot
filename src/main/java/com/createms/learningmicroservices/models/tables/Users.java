package com.createms.learningmicroservices.models.tables;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity

public class Users {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long userId;

    @Column(unique = true)
    @NotBlank(message = "Email can't be empty")
    private String email;

    @Column
    @NotBlank(message = "Password can't be empty")
    private String password;

    @Column
    private String fullName;

    @Column
    @Size(min = 18, max = 150)
    private int age;

    public Users(String email, String password, String fullName, int age) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
    }

    public Users() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age && Objects.equals(userId, users.userId) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(fullName, users.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, fullName, age);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
