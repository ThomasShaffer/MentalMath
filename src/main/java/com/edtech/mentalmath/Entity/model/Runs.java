package com.edtech.mentalmath.Entity.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_runs")
@Data
public class Runs {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User run_user;

    @OneToMany
    private List<Run> run;
}
