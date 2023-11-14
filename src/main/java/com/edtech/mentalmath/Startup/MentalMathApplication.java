package com.edtech.mentalmath.Startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan({"com.edtech.mentalmath.Controllers", "com.edtech.mentalmath.Service"})
@EntityScan({"com.edtech.mentalmath.Entity"})
@EnableJpaRepositories({"com.edtech.mentalmath.Repository"})
public class MentalMathApplication {

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/*").permitAll().and().csrf().disable();
            http.headers().frameOptions().disable();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MentalMathApplication.class, args);
    }

}
