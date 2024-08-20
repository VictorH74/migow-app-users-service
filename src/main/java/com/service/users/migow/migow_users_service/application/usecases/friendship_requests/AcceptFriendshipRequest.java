package com.service.users.migow.migow_users_service.application.usecases.friendship_requests;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.users.migow.migow_users_service.domain.entities.Friendship;
import com.service.users.migow.migow_users_service.domain.entities.FriendshipRequest;
import com.service.users.migow.migow_users_service.domain.entities.User;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipPK;
import com.service.users.migow.migow_users_service.domain.entities.pks.FriendshipRequestPK;
import com.service.users.migow.migow_users_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.AcceptFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.DeleteFriendshipRequestUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.friendship_requests.GetFriendshipRequestByIdUseCase;
import com.service.users.migow.migow_users_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AcceptFriendshipRequest implements AcceptFriendshipRequestUseCase {
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final DeleteFriendshipRequestUseCase deleteFriendshipRequestUseCase;
    private final GetFriendshipRequestByIdUseCase getFriendshipRequestByIdUseCase;
    private final FriendshipRepository friendshipRepository;

    @Override
    @Transactional
    public void execute(UUID ownerId, UUID targetId) {
        User owner = getUserByIdUseCase.execute(ownerId).toUser();
        User target = getUserByIdUseCase.execute(targetId).toUser();
        FriendshipRequestPK pk = new FriendshipRequestPK();
        pk.setOwner(owner);
        pk.setTarget(target);
        FriendshipRequest fr = getFriendshipRequestByIdUseCase.execute(pk);

        FriendshipPK fPK = new FriendshipPK();
        fPK.setUser(fr.getId().getOwner());
        fPK.setFriendUser(fr.getId().getTarget());

        Friendship f = new Friendship();
        f.setId(fPK);

        friendshipRepository.createFriendship(f);

        deleteFriendshipRequestUseCase.execute(pk);
    }

}
