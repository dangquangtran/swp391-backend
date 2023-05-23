package com.swp391.admin.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String imageurl;
    private String role;

    public User(String firstname, String lastname, String email, String password, String imageurl, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.imageurl = imageurl;
        this.role = role;
    }
}
