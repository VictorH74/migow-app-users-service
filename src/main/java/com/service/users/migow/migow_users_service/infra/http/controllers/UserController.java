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

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.GetAllFollowersByFollowingIdUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.CreateUserUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByLoginUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByUsernameUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.UpdateUserByIdUseCase;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.UserCredentials;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;
import com.service.users.migow.migow_users_service.infra.http.dtos.UpdateUserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    private final GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetUserByUsernameUseCase getUserByUsernameUseCase;
    private final GetUserByLoginUseCase getUserByLoginUseCase;
    private final UpdateUserByIdUseCase updateUserByIdUseCase;
    private final CreateUserUseCase createUserUseCase;

    private final GetAllFollowersByFollowingIdUseCase getAllFollowersByFollowingIdUseCase;

    public UserController(GetAllUserByUsernamePrefixUseCase getAllUserByUsernamePrefixUseCase,
            GetUserByIdUseCase getUserByIdUseCase, GetUserByUsernameUseCase getUserByUsernameUseCase,
            GetUserByLoginUseCase getUserByLoginUseCase, UpdateUserByIdUseCase updateUserByIdUseCase,
            CreateUserUseCase createUserUseCase,
            GetAllFollowersByFollowingIdUseCase getAllFollowersByFollowingIdUseCase) {
        this.getAllUserByUsernamePrefixUseCase = getAllUserByUsernamePrefixUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getUserByUsernameUseCase = getUserByUsernameUseCase;
        this.getUserByLoginUseCase = getUserByLoginUseCase;
        this.updateUserByIdUseCase = updateUserByIdUseCase;
        this.createUserUseCase = createUserUseCase;
        this.getAllFollowersByFollowingIdUseCase = getAllFollowersByFollowingIdUseCase;
    }

    @GetMapping
    public Page<SimpleUserDTO> findUsersByUsernamePrefix(
            @RequestParam(value = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllUserByUsernamePrefixUseCase.execute(usernamePrefix, pageable);
    }

    @GetMapping("/username/{username}")
    public SimpleUserDTO getUserByUsername(@PathVariable String username) {
        return getUserByUsernameUseCase.execute(username);
    }

    @GetMapping("/{userId}")
    public SimpleUserDTO getUserById(@PathVariable UUID userId) {
        return getUserByIdUseCase.execute(userId);
    }

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

    @GetMapping("/{userId}/followers")
    public Page<SimpleUserDTO> getFollowersByFollowingIdAndUsernamePrefix(
            @PathVariable UUID userId,
            @RequestParam(name = "usernamePrefix", defaultValue = "") String usernamePrefix,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return getAllFollowersByFollowingIdUseCase.execute(userId, usernamePrefix, pageable);
    }

    // @DeleteMapping("/users/{id}")
    // public String updateUser(User user) {
    // }

    @PostMapping("auth")
    public String login(@RequestBody UserCredentials credentials) {
        User retrievedUser = getUserByLoginUseCase.execute(credentials.getLogin());

        // TODO: check if credentials.password matchs with retrievedUser.password,
        // create json web token and return

        return "";
    }

    // TODO: delete user (and settings) mapping

}
