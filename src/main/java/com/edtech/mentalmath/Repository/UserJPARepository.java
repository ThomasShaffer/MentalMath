package com.edtech.mentalmath.Repository;

import com.edtech.mentalmath.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserJPARepository extends CrudRepository<User, Long> {

    @Query("select user from User user where user.id = :id")
    List<User> findAllUsersLol(@Param("id") int id);
}
