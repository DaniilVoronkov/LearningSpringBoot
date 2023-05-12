package com.createms.learningmicroservices.models.tables;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class Users {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long userId;

    @Column
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


}
