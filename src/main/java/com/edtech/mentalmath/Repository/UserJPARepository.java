package com.edtech.mentalmath.Repository;

import com.edtech.mentalmath.Entity.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserJPARepository extends CrudRepository<User, Long> {

    @Query(value="select count(*) is not 0 from User user where user.user_name = :user_name")
    boolean userExistsAlreadyByName(@Param("user_name") String user_name);

    @Query(value="select count(*) is not 0 from User user where user.user_name = :user_name and user.user_password = :user_password")
    boolean authorizedLoginByUsernameAndPassword(@Param("user_name") String user_name, @Param("user_password") String user_password);
}
