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

    // public Page<String> findFollowersByFollowingId(UUID followingId, Pageable
    // pageable) {
    // return followerRepository.findFollowersByFollowingId(followingId, pageable)
    // .map(follower -> follower.getId().getFollowerUser().toString());
    // }

    public Page<SimpleUserDTO> findFollowersByFollowingId(UUID followingId, String usernamePrefix, Pageable pageable) {
        userService.findUserById(followingId);
        return followerRepository.findFollowersByFollowingId(followingId, usernamePrefix, pageable)
                .map(follower -> {
                    User user = follower.getId().getFollowerUser();
                    SimpleUserDTO userDTO = new SimpleUserDTO(user);
                    return userDTO;
                });
    }

    public List<Follower> findAllFollowersByFollowingId(UUID followingId) {
        userService.findUserById(followingId);
        return followerRepository.findFollowersByFollowingId(followingId, "", Pageable.unpaged()).getContent();
    }

    public Page<FollowerUserDTO> findDetailedUsers(String usernamePrefix, UUID followingId, Pageable pageable) {
        Page<SimpleUserDTO> users = userService.findUsersByUsernamePrefix(usernamePrefix, pageable);

        return users.map(simpleUserDTO -> {
            boolean isFollower = this.isFollower(simpleUserDTO.getId(), followingId);            
            return new FollowerUserDTO(simpleUserDTO.toUser(), isFollower);
        });
    }

    public boolean isFollower(UUID followerId, UUID followingId) {
        userService.findUserById(followerId);
        userService.findUserById(followingId);
        return followerRepository.isFollower(followerId, followingId);
    }

    public Long findCommonFollowerCount(UUID userId, UUID targetUser) {
        userService.findUserById(userId);
        List<Follower> followers = this.findAllFollowersByFollowingId(userId);

        return followers.stream()
                .filter(follower -> followerRepository.isFollower(follower.getId().getFollowerUser().getId(),
                        targetUser))
                .count();

    }

}
