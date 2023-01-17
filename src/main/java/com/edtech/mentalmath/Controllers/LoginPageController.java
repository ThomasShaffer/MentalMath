package com.edtech.mentalmath.Controllers;

import com.edtech.mentalmath.Entity.dto.UserDTO;
import com.edtech.mentalmath.Entity.model.User;
import com.edtech.mentalmath.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@RestController
@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class LoginPageController {

    private UserJPARepository userJPARepository;

    @Autowired
    public LoginPageController(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    @PostMapping("/login")
    public ResponseEntity postLoginPage(@RequestBody UserDTO userDTO) {
        boolean authorized;
        User user = User
                .builder()
                .user_name(userDTO.getUsername())
                .user_password(userDTO.getPassword())
                .build();
        try {
            authorized = userJPARepository.authorizedLoginByUsernameAndPassword(user.getUser_name(), user.getUser_password());
            System.out.println(authorized);
        } catch (Exception e) {
            System.out.println(e.getCause());
            return ResponseEntity.badRequest().body("something went wrong");
        }
        return ResponseEntity.accepted().body(new HashMap<>(){{ put("authorized" , authorized); }});
    }

}
