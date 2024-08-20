package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.service.users.migow.migow_users_service.application.dtos.friendship_requests.CreateDeleteFriendshipRequestDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendship_requests.ResponseFriendshipRequestDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendships.CreateDeleteFriendshipDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshipStatusDTO;
import com.service.users.migow.migow_users_service.application.dtos.friendships.FriendshiptCommonCountDTO;
import com.service.users.migow.migow_users_service.domain.enums.FriendshipStatusEnum;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.CreateFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.GetAllOwnerFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.GetAllTargetFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.DeleteFriendshipUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetCommonFriendshipCountUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.users.migow.migow_users_service.infra.helpers.SecurityUtils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/friendships")
@AllArgsConstructor
@Log4j2
public class FriendshipController {
    private final GetFriendshipStatusUseCase gifsUseCase;
    private final GetCommonFriendshipCountUseCase gcfcUseCase;
    private final CreateFriendshipRequestUseCase createFriendshipRequestUseCase;
    private final DeleteFriendshipUseCase deleteFriendshipUseCase;
    private final GetAllOwnerFriendshipRequestUseCase getAllOwnerFriendshipRequestUseCase;
    private final GetAllTargetFriendshipRequestUseCase getAllTargetFriendshipRequestUseCase;

    @GetMapping("/sent-requests")
    public Page<ResponseFriendshipRequestDTO> getSentRequests(
            @RequestParam UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "20") int pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllOwnerFriendshipRequestUseCase.execute(userId, pageable);
    }

    @GetMapping("/received-requests")
    public Page<ResponseFriendshipRequestDTO> getReceivedRequests(
            @RequestParam UUID userId,
            @RequestParam(name = "pageNumber", defaultValue = "20") int pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllTargetFriendshipRequestUseCase.execute(userId, pageable);
    }

    @PostMapping("/request")
    public ResponseEntity<String> createFriendship(@RequestBody CreateDeleteFriendshipRequestDTO obj) {
        log.info("Friendship request created!");

        // TODO: provide created user to kafka
        createFriendshipRequestUseCase.execute(obj);

        log.info("Friendship request created!");

        return ResponseEntity.status(HttpStatus.CREATED).body("Friendship request created!");
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

        FriendshipStatusEnum friendshipStatus = gifsUseCase.execute(userId, friendId);
        return ResponseEntity.status(200).body(new FriendshipStatusDTO(friendshipStatus));
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
