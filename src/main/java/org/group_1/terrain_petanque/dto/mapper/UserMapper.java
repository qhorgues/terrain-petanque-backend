package org.group_1.terrain_petanque.dto.mapper;

import org.group_1.terrain_petanque.dto.UserDTO;
import org.group_1.terrain_petanque.dto.UserInputDTO;
import org.group_1.terrain_petanque.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * This interface representer a mapper (UserDTO <=> User) and (UserInputDTO => User).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface UserMapper {
    /**
     * This method converts a user DTO into a user Entity.
     *
     * @param userDTO The user DTO.
     * @return Return the user Entity.
     */
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO userDTO);

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
    UserDTO toDTO(User userEntity);

    /**
     * This method update an entity with the DTO.
     *
     * @param userEntity The entity to updated.
     * @param userInputDTO The DTO.
     */
    @BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void update(@MappingTarget User userEntity, UserInputDTO userInputDTO);
}
