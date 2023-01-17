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
    @GeneratedValue
    private Long id;

    @Column(nullable=false, unique=true)
    private String user_name;

    @Column(nullable=false, unique=false)
    private String user_password;

    @JoinColumn(name="runs")
    private Long runs;

    public User(String username, String password) {
        this.user_name = username;
        this.user_password = password;
    }
}
