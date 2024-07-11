package com.service.users.migow.migow_users_service.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.users.migow.migow_users_service.domain.entities.Follower;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.infra.db.repositories.jpa.JpaFollowerRepository;
import com.service.users.migow.migow_users_service.infra.http.dtos.FollowerUserDTO;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

@Service
public class FollowerService {

    @Autowired
    JpaFollowerRepository followerRepository;
    @Autowired
    UserService userService;

    // public Page<String> findFollowersByFollowedId(UUID followedId, Pageable
    // pageable) {
    // return followerRepository.findFollowersByFollowedId(followedId, pageable)
    // .map(follower -> follower.getId().getFollowerUser().toString());
    // }

    public Page<SimpleUserDTO> findFollowersByFollowedId(UUID followedId, String usernamePrefix, Pageable pageable) {
        userService.findUserById(followedId);
        return followerRepository.findFollowersByFollowedId(followedId, usernamePrefix, pageable)
                .map(follower -> {
                    User user = follower.getId().getFollowerUser();
                    SimpleUserDTO userDTO = new SimpleUserDTO(user);
                    return userDTO;
                });
    }

    public List<Follower> findAllFollowersByFollowedId(UUID followedId) {
        userService.findUserById(followedId);
        return followerRepository.findFollowersByFollowedId(followedId, "", Pageable.unpaged()).getContent();
    }

    public Page<FollowerUserDTO> findDetailedUsers(String usernamePrefix, UUID followedId, Pageable pageable) {
        Page<SimpleUserDTO> users = userService.findUsersByUsernamePrefix(usernamePrefix, pageable);

        return users.map(simpleUserDTO -> {
            boolean isFollower = this.isFollower(simpleUserDTO.getId(), followedId);            
            return new FollowerUserDTO(simpleUserDTO.toUser(), isFollower);
        });
    }

    public boolean isFollower(UUID followerId, UUID followedId) {
        userService.findUserById(followerId);
        userService.findUserById(followedId);
        return followerRepository.isFollower(followerId, followedId);
    }

    public Long findCommonFollowerCount(UUID userId, UUID targetUser) {
        userService.findUserById(userId);
        List<Follower> followers = this.findAllFollowersByFollowedId(userId);

        return followers.stream()
                .filter(follower -> followerRepository.isFollower(follower.getId().getFollowerUser().getId(),
                        targetUser))
                .count();

    }

}
