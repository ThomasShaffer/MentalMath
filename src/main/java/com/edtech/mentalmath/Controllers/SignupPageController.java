package com.edtech.mentalmath.Controllers;

import com.edtech.mentalmath.Entity.dto.UserDTO;
import com.edtech.mentalmath.Entity.model.User;
import com.edtech.mentalmath.Service.SignupService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class SignupPageController {

    @Autowired
    private SignupService signupService;

    public SignupPageController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping(path="/signup")
    public ResponseEntity postSignupPage(@RequestBody UserDTO userDTO) {
        User user = User.builder()
                .user_name(userDTO.getUsername())
                .user_password(userDTO.getPassword())
                .build();
        boolean successfulSignup = signupService.trySignup(user);
        return ResponseEntity.ok(new HashMap<>(){{ put("successful" , successfulSignup); }});

        //Need to create some sort of DTO -> Entity Model mapper
    }

}
