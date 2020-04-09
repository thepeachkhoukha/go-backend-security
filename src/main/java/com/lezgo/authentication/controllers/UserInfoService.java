package com.lezgo.authentication.controllers;

import com.lezgo.authentication.entities.Friendship;
import com.lezgo.authentication.entities.UserCircle;
import com.lezgo.authentication.entities.UserDetails;
import com.lezgo.authentication.models.FriendshipRequest;
import com.lezgo.authentication.repository.UserCircleRepository;
import com.lezgo.authentication.repository.UserDetailsRepository;
import com.lezgo.authentication.repository.UserFriendshipCircleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserCircleRepository userCircleRepository;

    @Autowired
    private UserFriendshipCircleRepository ufcRepository;
    public UserDetails userInfo(String username){
        UserDetails userDetails = userDetailsRepository.findByUsername(username);
        return userDetails;
    }

    public List<UserCircle> getUserCircle(String username){
        return userCircleRepository.getUserCircle(username);
    }

    public boolean checkFriendship(String username, String friendname){
        return ufcRepository.findByUsernameAndFriendname(username, friendname) != null;
    }

    public boolean addFriendship(FriendshipRequest friendshipRequest){
        if(!checkFriendship(friendshipRequest.getUsername(), friendshipRequest.getFriendname())){
            Friendship friendship = Friendship.builder()
                    .username(friendshipRequest.getUsername())
                    .friendname(friendshipRequest.getFriendname())
                    .build();
            ufcRepository.save(friendship);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteFriendship(String username, String friendname){
        if(checkFriendship(username, friendname)){
            ufcRepository.delete(ufcRepository.findByUsernameAndFriendname(username, friendname));
            return true;
        }
        else {
            return false;
        }
    }
}
