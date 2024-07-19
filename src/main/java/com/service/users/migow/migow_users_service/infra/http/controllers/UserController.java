package com.service.users.migow.migow_users_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.migow.migow_users_service.application.dtos.users.DetailedUserDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.ProfileUserDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.application.dtos.users.UpdateUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendships.GetAllUserFriendshipsUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.CreateUserUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetAllDetailedByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByLoginUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByUsernameUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.UpdateUserByIdUseCase;
import com.service.users.migow.migow_users_service.infra.helpers.CustomPage;

@RestController
@RequestMapping("/users")
public class UserController {

    private final GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetUserByUsernameUseCase getUserByUsernameUseCase;
    private final GetUserByLoginUseCase getUserByLoginUseCase;
    private final GetAllDetailedByUsernamePrefixUseCase getAllDetailedByUsernamePrefixUseCase;
    private final UpdateUserByIdUseCase updateUserByIdUseCase;
    private final CreateUserUseCase createUserUseCase;

    private final GetAllUserFriendshipsUseCase getAllUserFriendByUsernameUseCase;

    public UserController(GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase,
            GetUserByIdUseCase getUserByIdUseCase, GetUserByUsernameUseCase getUserByUsernameUseCase,
            GetUserByLoginUseCase getUserByLoginUseCase, UpdateUserByIdUseCase updateUserByIdUseCase,
            GetAllDetailedByUsernamePrefixUseCase getAllDetailedByUsernamePrefixUseCase,
            CreateUserUseCase createUserUseCase,
            GetAllUserFriendshipsUseCase getAllUserFriendByUsernameUseCase) {
        this.getAllUserByUsernamePrefixUseCase = getAllUserByUsernamePrefixUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getUserByUsernameUseCase = getUserByUsernameUseCase;
        this.getUserByLoginUseCase = getUserByLoginUseCase;
        this.updateUserByIdUseCase = updateUserByIdUseCase;
        this.createUserUseCase = createUserUseCase;
        this.getAllUserFriendByUsernameUseCase = getAllUserFriendByUsernameUseCase;
        this.getAllDetailedByUsernamePrefixUseCase = getAllDetailedByUsernamePrefixUseCase;
    }

    // Return simple users
    @GetMapping
    public CustomPage<SimpleUserDTO> findUsersByUsernamePrefix(
            @RequestParam(value = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllUserByUsernamePrefixUseCase.execute(usernamePrefix, pageable);
    }

    /*
     * Return simple users with an additional prop that tells whether the user
     * follows the user of the given id
     */
    @GetMapping("/by/{userId}")
    public Page<DetailedUserDTO> findDetailedUsersByUsernamePrefix(
            @PathVariable UUID userId,
            @RequestParam(name = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllDetailedByUsernamePrefixUseCase.execute(usernamePrefix, userId, pageable);
    }

    // return user friendships by given id
    @GetMapping("/{userId}/friendships")
    public Page<SimpleUserDTO> getUserFriendshipsByUsernamePrefix(
            @PathVariable UUID userId,
            @RequestParam(name = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return getAllUserFriendByUsernameUseCase.execute(userId, usernamePrefix, pageable);
    }

    // Return user by given username
    @GetMapping("/username/{username}")
    public ProfileUserDTO getUserByUsername(@PathVariable String username) {
        return getUserByUsernameUseCase.execute(username);
    }

    // Return user by given id
    @GetMapping("/{userId}")
    public SimpleUserDTO getUserById(@PathVariable UUID userId) {
        return getUserByIdUseCase.execute(userId);
    }

    // Update user by given id
    @PatchMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody UpdateUserDTO updateUserDTO) {
        // try {
        updateUserByIdUseCase.execute(userId, updateUserDTO);
        // } catch (UserNotFounException e) {
        // return ResponseEntity.status(404).body(e.getMessage());
        // }
        return ResponseEntity.status(200).body("User update successfuly!");
    }

    @PostMapping
    public User createUser(@RequestBody User entity) {
        User user = createUserUseCase.execute(entity);

        // TODO: provide created user to kafka

        return user;
    }

    // @DeleteMapping("/users/{id}")
    // public String updateUser(User user) {
    // }

    // TODO: delete user (and settings) mapping

}
