package com.edtech.mentalmath.Controllers;

import com.edtech.mentalmath.Entity.dto.UserDTO;
import com.edtech.mentalmath.Entity.model.User;
import com.edtech.mentalmath.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity postLoginPage(@RequestBody UserDTO userDTO) {
        User user = User
                .builder()
                .userName(userDTO.getUsername())
                .userPassword(userDTO.getPassword())
                .build();
        boolean authorized = userService.tryLogin(user);
        return ResponseEntity.accepted().body(new HashMap<>(){{ put("authorized" , authorized); }});
    }

    @PostMapping(path="/signup")
    public ResponseEntity postSignupPage(@RequestBody UserDTO userDTO) {
        User user = User.builder()
                .userName(userDTO.getUsername())
                .userPassword(userDTO.getPassword())
                .build();
        boolean successfulSignup = userService.trySignup(user);
        return ResponseEntity.ok(new HashMap<>() {
            { put("successful" , successfulSignup);}
            { put("message", successfulSignup ? "created" : "cant create user");}
        });
    }

}
