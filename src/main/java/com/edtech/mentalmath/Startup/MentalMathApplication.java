package com.edtech.mentalmath.Startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.edtech.mentalmath.entity"})
@EnableJpaRepositories({"com.edtech.mentalmath.Repository"})
public class MentalMathApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentalMathApplication.class, args);
    }


}
