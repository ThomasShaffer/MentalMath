package com.edtech.mentalmath.Service;

import com.edtech.mentalmath.Entity.model.User;
import com.edtech.mentalmath.Repository.UserJPARepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;

    public UserService(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }

    public boolean tryLogin(User user) {
        boolean authorized = false;
        try {
            authorized = userJPARepository.authorizedLoginByUsernameAndPassword(user.getUserName(), user.getUserPassword());
            System.out.println("Authorized: " + authorized);
            return authorized;
        } catch (Exception e) {
            System.out.println("Cannot login due to error: " + e);
            return authorized;
        }
    }

    public boolean trySignup(User user) {
        try {
            if (userJPARepository.userExistsAlreadyByName(user.getUserName())) {
                System.out.println("already has said user");
                return false;
            }
            else userJPARepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Cannot signup due to error: " + e);
            return false;
        }
    }

    public User findUserById(Long userId) {
        try {
            return userJPARepository.findById(userId).get();
        } catch (Exception e) {
            System.out.println("Cannot find user due to: " + e);
        }
        return new User();
    }
}
