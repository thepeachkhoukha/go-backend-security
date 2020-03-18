package com.lezgo.authentication.repository;

import com.lezgo.authentication.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    UserDetails findByUsername(String username);
}
