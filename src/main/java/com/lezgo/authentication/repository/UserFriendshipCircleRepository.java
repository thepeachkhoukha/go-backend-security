package com.lezgo.authentication.repository;

import com.lezgo.authentication.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserFriendshipCircleRepository extends JpaRepository<Friendship, Integer> {
    Friendship findByUsernameAndFriendname(@Param(value = "username") String username, @Param(value = "friendname") String friendname);

    @Query(nativeQuery = true, value ="DELETE FROM user_circle WHERE username = :username AND friendname = :friendname")
    void deleteByUsernameAndFriendname(@Param(value = "username") String username, @Param(value = "friendname") String friendname);
}
