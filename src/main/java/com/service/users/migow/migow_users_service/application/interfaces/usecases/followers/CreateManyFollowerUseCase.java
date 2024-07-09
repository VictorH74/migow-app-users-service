package com.service.users.migow.migow_users_service.application.interfaces.usecases.followers;

import java.util.List;

import com.service.users.migow.migow_users_service.domain.entities.Follower;

public interface CreateManyFollowerUseCase {
    List<Follower> execute(List<Follower> objs);

}
