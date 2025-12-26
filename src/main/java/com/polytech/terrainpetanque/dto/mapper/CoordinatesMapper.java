package com.polytech.terrainpetanque.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.polytech.terrainpetanque.dto.input.CoordinatesInputDTO;
import com.polytech.terrainpetanque.dto.output.CoordinatesOutputDTO;
import com.polytech.terrainpetanque.entity.Coordinates;
import com.polytech.terrainpetanque.entity.Court;

/**
 * This interface representer a mapper (CoordinatesOutputDTO <=> Coordinates).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface CoordinatesMapper {

    /**
     * This method converts coordinates DTO into coordinates Entity.
     *
     * @param coordinatesInputDTO The coordinates DTO.
     * @return Return the coordinates Entity.
     */
    @Mapping(target = "court", ignore = true)
    Coordinates toEntity(CoordinatesInputDTO coordinatesInputDTO);



    /**
     * This method converts coordinates Entity into coordinates DTO.
     *
     * @param coordinatesEntity The coordinates Entity.
     * @return Return the coordinates DTO.
     */
    @Mapping(source = "court", target = "courtId")
    CoordinatesOutputDTO toDTO(Coordinates coordinatesEntity);



    /**
     * This method update partially an entity with the DTO.
     *
     * @param coordinatesEntity The entity to updated.
     * @param coordinatesInputDTO The DTO.
     */
    @Mapping(target = "court", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Coordinates coordinatesEntity, CoordinatesInputDTO coordinatesInputDTO);



    /**
     * This method update fully an entity with the DTO.
     *
     * @param coordinatesEntity The entity to updated.
     * @param coordinatesInputDTO The DTO.
     */
    @Mapping(target = "court", ignore = true)
    void fullUpdate(@MappingTarget Coordinates coordinatesEntity, CoordinatesInputDTO coordinatesInputDTO);



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
