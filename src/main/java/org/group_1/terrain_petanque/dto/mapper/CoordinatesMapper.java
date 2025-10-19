package org.group_1.terrain_petanque.dto.mapper;

import org.group_1.terrain_petanque.dto.CoordinatesDTO;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * This interface representer a mapper (CoordinatesDTO <=> Coordinates).
 */
@Mapper(componentModel = "spring")
public interface CoordinatesMapper {

    /**
     * This field represents an instance of the mapper.
     */
    final CoordinatesMapper INSTANCE = Mappers.getMapper(CoordinatesMapper.class);
    


    /**
     * This method converts coordinates DTO into coordinates Entity.
     * 
     * @param coordinatesDTO The coordinates DTO.
     * @return Return the coordinates Entity.
     */
    @Mapping(target = "courts", ignore = true)
    Coordinates toToEntity(CoordinatesDTO coordinatesDTO);



    /**
     * This method converts coordinates Entity into coordinates DTO.
     * 
     * @param coordinatesEntity The coordinates Entity.
     * @return Return the coordinates DTO.
     */
    @Mapping(source = "courts", target = "courtsId")
    CoordinatesDTO toDTO(Coordinates coordinatesEntity);



    /**
     * This method converts a court into an id.
     * 
     * @param courtEntity The court.
     * @return Return the court's id.
     */
    default Integer map(Court courtEntity) {
        return courtEntity == null ? null : courtEntity.getId();
    }

}
