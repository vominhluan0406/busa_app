package com.luanvo.busa.repository;

import com.luanvo.busa.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * From users WHERE username = :user_name LIMIT 1", nativeQuery = true)
    UserEntity getByUserName(@Param("user_name") String username);
}
