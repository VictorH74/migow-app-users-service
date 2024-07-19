package com.service.users.migow.migow_users_service.application.usecases.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.application.dtos.users.SimpleUserDTO;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetAllUserByUsernamePrefixUseCase;
import com.service.users.migow.migow_users_service.infra.helpers.CustomPage;

@Component
public class GetAllUserByUsernamePrefix implements GetAllUserByUsernamePrefixUseCase {
    private final UserRepository userRepository;

    public GetAllUserByUsernamePrefix(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomPage<SimpleUserDTO> execute(String usernamePrefix, Pageable pageable) {
        Page<User> userPage = userRepository.getAllUserByUsernamePrefix(usernamePrefix, pageable);
        Page<SimpleUserDTO> dtoPage = userPage.map(user -> new SimpleUserDTO(user));
        return new CustomPage<>(dtoPage);
    }

}
