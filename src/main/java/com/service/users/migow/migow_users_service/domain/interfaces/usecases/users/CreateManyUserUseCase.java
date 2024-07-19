package com.service.users.migow.migow_users_service.domain.interfaces.usecases.users;

import java.util.List;

import com.service.users.migow.migow_users_service.domain.entities.User;

public interface CreateManyUserUseCase {
    List<User> execute(List<User> objs);
}
