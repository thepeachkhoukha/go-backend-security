package com.lezgo.authentication.repository;

import com.lezgo.authentication.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    UserDetails findByUsername(@Param(value = "username") String username);
}
