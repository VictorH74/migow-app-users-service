package com.service.users.migow.migow_users_service.main.factories.usecases.followers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.users.migow.migow_users_service.application.interfaces.usecases.followers.DeleteFollowerByIdUseCase;
import com.service.users.migow.migow_users_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.users.migow.migow_users_service.application.usecases.followers.DeleteFollowerById;
import com.service.users.migow.migow_users_service.infra.db.repositories.implementations.FollowerRepositoryImpl;

@Configuration
public class DeleteFollowerByIdFactory {
    @Bean
    public DeleteFollowerByIdUseCase deleteFollowerByIdUseCase(FollowerRepositoryImpl followerRepository,
            GetUserByIdUseCase getUserByIdUseCase) {
        return new DeleteFollowerById(followerRepository, getUserByIdUseCase);
    }
}
