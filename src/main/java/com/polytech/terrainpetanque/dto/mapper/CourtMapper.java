package com.polytech.terrainpetanque.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.polytech.terrainpetanque.dto.output.CourtOutputDTO;
import com.polytech.terrainpetanque.entity.Coordinates;
import com.polytech.terrainpetanque.entity.Court;

/**
 * This interface representer a mapper (CourtOutputDTO <=> Court).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface CourtMapper {

    /**
     * This method converts a court DTO into a court Entity.
     *
     * @param courtOutputDTO The court DTO.
     * @return Return the court Entity.
     */
    @Mapping(source = "coordinatesId", target = "coordinates")
    Court toEntity(CourtOutputDTO courtOutputDTO);



    /**
     * This method converts a court Entity into a court DTO.
     *
     * @param courtEntity The court Entity.
     * @return Return the court DTO.
     */
    @Mapping(source = "coordinates", target = "coordinatesId")
    CourtOutputDTO toDTO(Court courtEntity);



    /**
     * This method update partialy an entity with the DTO.
     *
     * @param courtEntity The entity to updated.
     * @param courtOutputDTO The DTO.
     */
    @Mapping(source = "coordinatesId", target = "coordinates")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Court courtEntity, CourtOutputDTO courtOutputDTO);



    /**
     * This method update fully an entity with the DTO.
     *
     * @param courtEntity The entity to updated.
     * @param courtOutputDTO The DTO.
     */
    @Mapping(source = "coordinatesId", target = "coordinates")
    void fullUpdate(@MappingTarget Court courtEntity, CourtOutputDTO courtOutputDTO);



    /**
     * This method converts coordinates into an id.
     *
     * @param coordinatesEntity The coordinates.
     * @return Return the coordinates' id.
     */
    default Integer map(Coordinates coordinatesEntity) {
        return coordinatesEntity == null ? null : coordinatesEntity.getId();
    }



    /**
     * This method converts an id into coordinates.
     *
     * @param coordinatesId The id.
     * @return Return the coordinates.
     */
    default Coordinates map(Integer coordinatesId) {
        return Coordinates.obtainCoordinates(coordinatesId);
    }

}
