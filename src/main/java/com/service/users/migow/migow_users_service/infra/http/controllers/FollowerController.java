package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllDetailedUserFollowerUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetCommonFollowerCountUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetIsFollowerStatusUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.infra.http.dtos.FollowedDTO;
import com.service.users.migow.migow_users_service.infra.http.dtos.FollowerCountDTO;
import com.service.users.migow.migow_users_service.infra.http.dtos.FollowerUserDTO;

@RestController
@RequestMapping("/followers")
public class FollowerController {
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetAllDetailedUserFollowerUseCase gadufUseCase;
    private final GetIsFollowerStatusUseCase gifsUseCase;
    private final GetCommonFollowerCountUseCase gcfcUseCase;

    public FollowerController(GetUserByIdUseCase getUserByIdUseCase, GetAllDetailedUserFollowerUseCase gadufUseCase,
            GetIsFollowerStatusUseCase gifsUseCase, GetCommonFollowerCountUseCase gcfcUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.gadufUseCase = gadufUseCase;
        this.gifsUseCase = gifsUseCase;
        this.gcfcUseCase = gcfcUseCase;
    }

    @GetMapping("/{followedId}")
    public Page<FollowerUserDTO> findDetailedUsers(
            @RequestParam(name = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @PathVariable UUID followedId, @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return gadufUseCase.execute(usernamePrefix, followedId, pageable);
    }

    // @GetMapping("/of/{followedId}")
    // public

    @GetMapping("/{followedId}/followed-by/{followerId}")
    public ResponseEntity<Object> getFollowerdStatus(@PathVariable UUID followedId, @PathVariable UUID followerId) {
        getUserByIdUseCase.execute(followedId);
        getUserByIdUseCase.execute(followerId);
        if (followedId.toString().isEmpty() || followerId.toString().isEmpty())
            return ResponseEntity.status(400).body("followedId and followerId must be not empty");

        boolean followed = gifsUseCase.execute(followerId, followedId);
        return ResponseEntity.status(200).body(new FollowedDTO(followed));
    }

    @GetMapping("/common")
    public ResponseEntity<Object> getCommonFollowersCount(@RequestParam UUID userId, @RequestParam UUID targetId) {
        if (userId.toString().isEmpty() || targetId.toString().isEmpty())
            return ResponseEntity.status(400).body("userId and targetId must be not empty");

        Long count = gcfcUseCase.execute(userId, targetId);
        return ResponseEntity.status(200).body(new FollowerCountDTO(count));
    }

}
