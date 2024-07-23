package com.service.users.migow.migow_users_service.application.dtos.privacy_settings;

import com.service.users.migow.migow_users_service.domain.entities.PrivacySettings;

import lombok.Getter;

@Getter
public class SimplePrivacySettingsDTO {
    private final Long id;
    private final Integer imageProfileVisibility;
    private final Integer nameVisibility;
    private final Integer bioVisibility;
    private final Integer friendshipsVisibility;
    private final Integer activityVisibility;
    private final Integer onlineStatusVisibility;
    private final Integer messageReadConfirmationVisibility;

    public SimplePrivacySettingsDTO(PrivacySettings pSettings) {
        this.id = pSettings.getId();
        this.imageProfileVisibility = pSettings.getImageProfileVisibility();
        this.nameVisibility = pSettings.getNameVisibility();
        this.bioVisibility = pSettings.getBioVisibility();
        this.friendshipsVisibility = pSettings.getFriendshipsVisibility();
        this.activityVisibility = pSettings.getActivityVisibility();
        this.onlineStatusVisibility = pSettings.getOnlineStatusVisibility();
        this.messageReadConfirmationVisibility = pSettings.getMessageReadConfirmationVisibility();
    }

}
