package com.edtech.mentalmath.Startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.edtech.mentalmath.Controllers", "com.edtech.mentalmath.Service"})
@EntityScan({"com.edtech.mentalmath.Entity"})
@EnableJpaRepositories({"com.edtech.mentalmath.Repository"})
public class MentalMathApplication {

    public static void main(String[] args) {
        SpringApplication.run(MentalMathApplication.class, args);
    }


}
