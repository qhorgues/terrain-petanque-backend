package org.group_1.terrain_petanque.dto;

import lombok.Getter;
import lombok.Setter;
import org.group_1.terrain_petanque.entity.ReservationKey;
import org.group_1.terrain_petanque.entity.Terrain;
import org.group_1.terrain_petanque.entity.Utilisateur;

public class ReservationDTO {
    @Getter
    @Setter
    private ReservationKey id;

    @Getter
    @Setter
    private Utilisateur utilisateur;

    @Getter
    @Setter
    private Terrain terrain;

    @Getter
    @Setter
    private int reservation;

}
