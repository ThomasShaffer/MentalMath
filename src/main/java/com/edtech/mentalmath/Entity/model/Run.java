package com.edtech.mentalmath.Entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="run")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Run {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long runId;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="userId")
    private User userId;

    @Column(nullable=false)
    private String category;

    @Column(nullable=false)
    private int firstDigit;

    @Column(nullable=false)
    private int secondDigit;

    @Column(nullable=false)
    private boolean correct;

    @Column(nullable=false)
    private float timeElapsed;
}
