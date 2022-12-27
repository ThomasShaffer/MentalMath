package com.edtech.mentalmath.Entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, unique=false)
    private String user_name;

    @Column(nullable=false, unique=false)
    private String user_password;

    @JoinColumn(name="runs")
    private Long runs;
}
