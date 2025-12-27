package com.polytech.terrainpetanque.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.polytech.terrainpetanque.dto.input.CourtInputDTO;
import com.polytech.terrainpetanque.dto.output.CourtOutputDTO;
import com.polytech.terrainpetanque.entity.Court;

/**
 * This interface representer a mapper (CourtDTO <=> Court).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    uses = CoordinatesMapper.class
)
public interface CourtMapper {

    /**
     * This method converts a court DTO into a court Entity.
     *
     * @param courtInputDTO The court DTO.
     * @return Return the court Entity.
     */
    Court toEntity(CourtInputDTO courtInputDTO);



    /**
     * This method converts a court Entity into a court DTO.
     *
     * @param courtEntity The court Entity.
     * @return Return the court DTO.
     */
    CourtOutputDTO toDTO(Court courtEntity);



    /**
     * This method update partialy an entity with the DTO.
     *
     * @param courtEntity The entity to updated.
     * @param courtInputDTO The DTO.
     */
    @Mapping(target = "coordinates", qualifiedByName = "partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Court courtEntity, CourtInputDTO courtInputDTO);



    /**
     * This method update fully an entity with the DTO.
     *
     * @param courtEntity The entity to updated.
     * @param courtInputDTO The DTO.
     */
    @Mapping(target = "coordinates", qualifiedByName = "fullUpdate")
    void fullUpdate(@MappingTarget Court courtEntity, CourtInputDTO courtInputDTO);

}
