package org.group_1.terrain_petanque.dto.mapper;

import org.group_1.terrain_petanque.dto.CourtDTO;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * This interface representer a mapper (CourtDTO <=> Court).
 */
@Mapper(componentModel = "spring")
public interface CourtMapper {
    
    /**
     * This field represents an instance of the mapper.
     */
    final CourtMapper INSTANCE = Mappers.getMapper(CourtMapper.class);



    /**
     * This method converts a court DTO into a court Entity.
     * 
     * @param courtDTO The court DTO.
     * @return Return the court Entity.
     */
    @Mapping(target = "coordinates", ignore = true)
    Court toEntity(CourtDTO courtDTO);



    /**
     * This method converts a court Entity into a court DTO.
     * 
     * @param courtEntity The court Entity.
     * @return Return the court DTO.
     */
    @Mapping(source = "coordinates", target = "coordinatesId")
    CourtDTO toDTO(Court courtEntity);



    /**
     * This method converts coordinates into an id.
     * 
     * @param coordinatesEntity The coordinates.
     * @return Return the coordinates' id.
     */
    default Integer map(Coordinates coordinatesEntity) {
        return coordinatesEntity == null ? null : coordinatesEntity.getId();
    }

}
