package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.username = :credentials AND u.password = :password OR u.email = :credentials AND u.password = :password", nativeQuery = true)
    Optional<User> findByCredentials(@Param("credentials") String credentials, @Param("password") String password);
}
