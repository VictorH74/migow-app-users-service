package com.service.users.migow.migow_users_service.application.usecases.users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.interfaces.repositories.UserRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.DeleteUserByIdUseCase;

@Component
public class DeleteUserById implements DeleteUserByIdUseCase {

    private final UserRepository userRepository;

    private final KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${kafka.topic.userCreated}")
    private String userCreatedTopic;

    public DeleteUserById(UserRepository userRepository, KafkaTemplate<String, Object> kafkaTemplate) {

        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void execute(UUID id) {
        userRepository.deleteUserById(id);
        kafkaTemplate.send(userCreatedTopic, id);
    }

}
