package com.edtech.mentalmath.Controllers;

import com.edtech.mentalmath.Entity.User;
import com.edtech.mentalmath.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {


    @Autowired
    private UserJPARepository userJPARepository;

    @GetMapping("/")
    public String getHomePage() {
        User user = userJPARepository.findById(Long.valueOf(1)).get();
        return user.toString() == null ? "no users" : user.getUser_name();
    }
}
