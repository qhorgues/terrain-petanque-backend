package com.polytech.terrainpetanque.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.polytech.terrainpetanque.dto.input.UserInputDTO;
import com.polytech.terrainpetanque.dto.output.UserOutputDTO;
import com.polytech.terrainpetanque.entity.User;

/**
 * This interface representer a mapper (UserDTO <=> User).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface UserMapper {

    /**
     * This method converts a user input DTO into a user Entity.
     *
     * @param userInputDTO The user input DTO.
     * @return Return the user Entity.
     */
    User toEntity(UserInputDTO userInputDTO);



    /**
     * This method converts a user Entity into a user DTO.
     *
     * @param userEntity The user Entity.
     * @return Return the user DTO.
     */
    UserOutputDTO toDTO(User userEntity);



    /**
     * This method update partially an entity with the DTO.
     *
     * @param userEntity The entity to updated.
     * @param userInputDTO The DTO.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget User userEntity, UserInputDTO userInputDTO);



    /**
     * This method update fully an entity with the DTO.
     *
     * @param userEntity The entity to updated.
     * @param userInputDTO The DTO.
     */
    void fullUpdate(@MappingTarget User userEntity, UserInputDTO userInputDTO);

}
