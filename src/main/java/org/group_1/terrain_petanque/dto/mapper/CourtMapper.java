package org.group_1.terrain_petanque.dto.mapper;

import org.group_1.terrain_petanque.dto.CourtDTO;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * This interface representer a mapper (CourtDTO <=> Court).
 */
@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
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
    @Mapping(source = "coordinatesId", target = "coordinates")
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
     * This method update an entity with the DTO.
     * 
     * @param courtEntity The entity to updated.
     * @param courtDTO The DTO.
     */
    @Mapping(source = "coordinatesId", target = "coordinates")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Court courtEntity, CourtDTO courtDTO);



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
