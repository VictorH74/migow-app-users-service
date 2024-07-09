package com.service.users.migow.migow_users_service.application.usecases.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.users.migow.migow_users_service.application.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.infra.http.dtos.SimpleUserDTO;

public class GetAllUserByUsernamePrefix implements GetAllUserByUsernamePrefixUseCase {
    private final UserRepository userRepository;

    public GetAllUserByUsernamePrefix(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<SimpleUserDTO> execute(String usernamePrefix, Pageable pageable) {
        return userRepository.getAllUserByUsernamePrefix(usernamePrefix, pageable).map(user -> new SimpleUserDTO(user));
    }

}
