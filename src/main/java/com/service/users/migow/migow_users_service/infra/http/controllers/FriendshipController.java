package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshipDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshiptCommonCountDTO;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetCommonFriendshipCountUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/friendships")
@AllArgsConstructor
public class FriendshipController {
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetFriendshipStatusUseCase gifsUseCase;
    private final GetCommonFriendshipCountUseCase gcfcUseCase;

    @GetMapping("/{userId}/friendship-with/{friendId}")
    public ResponseEntity<Object> getFriendshipdStatus(@PathVariable UUID userId, @PathVariable UUID friendId) {
        if (userId.toString().isEmpty() || friendId.toString().isEmpty())
            return ResponseEntity.status(400).body("userId and friendId must be not empty");

        boolean friendshipStatus = gifsUseCase.execute(userId, friendId);
        return ResponseEntity.status(200).body(new FriendshipDTO(friendshipStatus));
    }

    @GetMapping("/common")
    public ResponseEntity<FriendshiptCommonCountDTO> getCommonFriendsCount(@RequestParam UUID userId,
            @RequestParam UUID targetId) {
        if (userId.toString().isEmpty() || targetId.toString().isEmpty())
            throw new IllegalArgumentException("userId and targetId must be not empty");

        FriendshiptCommonCountDTO commonCount = gcfcUseCase.execute(userId, targetId);
        return ResponseEntity.status(200).body(commonCount);
    }

}
