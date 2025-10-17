package org.group_1.terrain_petanque.dto;

import lombok.Getter;
import lombok.Setter;
import org.group_1.terrain_petanque.entity.Terrain;

import java.util.Set;

public class CoordonneesDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String latitude;

    @Getter
    @Setter
    private String longitude;

    @Getter
    @Setter
    private Set<Terrain> terrains;
}
