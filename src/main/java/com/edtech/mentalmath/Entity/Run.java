package com.edtech.mentalmath.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="run")
@Data
public class Run {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Runs runs;

    @Column(nullable = false)
    private String digits;

    @Column(nullable = false)
    private boolean correct;


}
