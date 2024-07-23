package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.dtos.friendships.CreateDeleteFriendshipDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshipDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshiptCommonCountDTO;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.CreateFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.DeleteFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetCommonFriendshipCountUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.users.migow.migow_users_service.infra.helpers.SecurityUtils;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/friendships")
@AllArgsConstructor
public class FriendshipController {
    private final GetFriendshipStatusUseCase gifsUseCase;
    private final GetCommonFriendshipCountUseCase gcfcUseCase;
    private final CreateFriendshipUseCase createFriendshipUseCase;
    private final DeleteFriendshipUseCase deleteFriendshipUseCase;

    @PostMapping
    public ResponseEntity<String> createFriendship(@RequestBody CreateDeleteFriendshipDTO obj) {
        createFriendshipUseCase.execute(obj);

        // TODO: provide created user to kafka

        return ResponseEntity.status(HttpStatus.CREATED).body("Friendship created!");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFriendship(@RequestBody CreateDeleteFriendshipDTO obj) {
        deleteFriendshipUseCase.execute(obj);

        // TODO: provide created user to kafka

        return ResponseEntity.status(HttpStatus.OK).body("Friendship deleted!");
    }

    @GetMapping("/{userId}/friendship-with/{friendId}")
    public ResponseEntity<Object> getFriendshipdStatus(@PathVariable UUID userId, @PathVariable UUID friendId) {
        if (userId.toString().isEmpty() || friendId.toString().isEmpty())
            return ResponseEntity.status(400).body("userId and friendId must be not empty");

        boolean friendshipStatus = gifsUseCase.execute(userId, friendId);
        return ResponseEntity.status(200).body(new FriendshipDTO(friendshipStatus));
    }

    @GetMapping("/common")
    public ResponseEntity<FriendshiptCommonCountDTO> getCommonFriendsCount(@RequestParam UUID targetId) {
        UUID userId = SecurityUtils.getAuthenticatedUserId();

        if (userId.toString().isEmpty() || targetId.toString().isEmpty())
            throw new IllegalArgumentException("userId and targetId must be not empty");

        FriendshiptCommonCountDTO commonCount = gcfcUseCase.execute(userId, targetId);
        return ResponseEntity.status(200).body(commonCount);
    }

}
