package com.service.users.migow.migow_users_service.domain.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "db_privacy_settings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrivacySettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    private User owner;
    private Integer imageProfileVisibility;
    private Integer nameVisibility;
    private Integer bioVisibility;
    private Integer friendshipsVisibility;
    private Integer activityVisibility;
    private Integer onlineStatusVisibility;
    private Integer messageReadConfirmationVisibility;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrivacySettings other = (PrivacySettings) obj;
        return Objects.equals(id, other.id);
    }

}
