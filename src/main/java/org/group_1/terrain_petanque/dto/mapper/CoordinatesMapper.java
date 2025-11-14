package org.group_1.terrain_petanque.dto.mapper;

import org.group_1.terrain_petanque.dto.CoordinatesDTO;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * This interface representer a mapper (CoordinatesDTO <=> Coordinates).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface CoordinatesMapper {

    /**
     * This method converts coordinates DTO into coordinates Entity.
     *
     * @param coordinatesDTO The coordinates DTO.
     * @return Return the coordinates Entity.
     */
    @Mapping(source = "courtId", target = "court")
    Coordinates toEntity(CoordinatesDTO coordinatesDTO);



    /**
     * This method converts coordinates Entity into coordinates DTO.
     *
     * @param coordinatesEntity The coordinates Entity.
     * @return Return the coordinates DTO.
     */
    @Mapping(source = "court", target = "courtId")
    CoordinatesDTO toDTO(Coordinates coordinatesEntity);



    /**
     * This method update partially an entity with the DTO.
     *
     * @param coordinatesEntity The entity to updated.
     * @param coordinatesDTO The DTO.
     */
    @Mapping(source = "courtId", target = "court")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Coordinates coordinatesEntity, CoordinatesDTO coordinatesDTO);



    /**
     * This method update fully an entity with the DTO.
     *
     * @param coordinatesEntity The entity to updated.
     * @param coordinatesDTO The DTO.
     */
    @Mapping(source = "courtId", target = "court")
    void fullUpdate(@MappingTarget Coordinates coordinatesEntity, CoordinatesDTO coordinatesDTO);



    /**
     * This method converts a court into an id.
     *
     * @param courtEntity The court.
     * @return Return the court's id.
     */
    default Integer map(Court courtEntity) {
        return courtEntity == null ? null : courtEntity.getId();
    }



    /**
     * This method converts an id into a court.
     *
     * @param courtId The od.
     * @return Return the court.
     */
    default Court map(Integer courtId) {
        return Court.obtainCourt(courtId);
    }
    
}
