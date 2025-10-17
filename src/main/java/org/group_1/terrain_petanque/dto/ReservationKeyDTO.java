package org.group_1.terrain_petanque.dto;

import lombok.Getter;
import lombok.Setter;

public class ReservationKeyDTO {
    @Getter
    @Setter
    private Long utilisateurId;

    @Getter
    @Setter
    private Long terrainId;
}
