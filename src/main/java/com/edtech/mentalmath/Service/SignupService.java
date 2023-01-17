package com.edtech.mentalmath.Service;

import com.edtech.mentalmath.Entity.model.User;
import com.edtech.mentalmath.Repository.UserJPARepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class SignupService {
    @Autowired
    private UserJPARepository userJPARepository;

    public SignupService(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    public boolean trySignup(User user) {
        try {
            if (userJPARepository.userExistsAlreadyByName(user.getUser_name())) { return false; }
            else userJPARepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("something");
            return false;
        }
    }
}
