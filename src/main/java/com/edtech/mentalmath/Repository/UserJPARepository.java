package com.edtech.mentalmath.Repository;

import com.edtech.mentalmath.Entity.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserJPARepository extends CrudRepository<User, Long> {

    @Query(value="select count(*) is not 0 from User user where user.userName = :userName")
    boolean userExistsAlreadyByName(@Param("userName") String userName);

    @Query(value="select count(*) is not 0 from User user where user.userName = :userName and user.userPassword = :userPassword")
    boolean authorizedLoginByUsernameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
