package com.lezgo.authentication.repository;

import com.lezgo.authentication.entities.UserCircle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCircleRepository extends JpaRepository<UserCircle, Integer> {
    @Query(nativeQuery = true, value = "SELECT lud.id, lud.username, lud.image FROM user_circle uc " +
            "INNER JOIN lezgo_user_details lud " +
            "ON uc.friendname = lud.username " +
            "WHERE uc.username = :username")
    List<UserCircle> getUserCircle(@Param(value = "username") String username);
}
