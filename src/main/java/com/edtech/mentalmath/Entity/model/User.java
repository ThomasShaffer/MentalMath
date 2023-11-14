package com.edtech.mentalmath.Entity.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String userName;

    @Column(nullable=false, unique=false)
    private String userPassword;

    public User(String username, String password) {
        this.userName = username;
        this.userPassword = password;
    }
}
