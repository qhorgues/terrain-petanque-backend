package com.polytech.terrainpetanque.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.polytech.terrainpetanque.dto.input.ReservationInputDTO;
import com.polytech.terrainpetanque.dto.output.ReservationOutputDTO;
import com.polytech.terrainpetanque.entity.Court;
import com.polytech.terrainpetanque.entity.Reservation;
import com.polytech.terrainpetanque.entity.User;

/**
 * This interface representer a mapper (ReservationDTO <=> Reservation).
 */
@Mapper(
    componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface ReservationMapper {

    /**
     * This method converts a reservation DTO into a reservation Entity.
     *
     * @param reservationInputDTO The reservation DTO.
     * @return Return the reservation Entity.
     */
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "court", ignore = true)
    Reservation toEntity(ReservationInputDTO reservationInputDTO);



    /**
     * This method converts a reservation Entity into a reservation DTO.
     *
     * @param reservationEntity The reservation Entity.
     * @return Return the reservation DTO.
     */
    @Mapping(source = "user", target = "userId")
    @Mapping(source = "court", target = "courtId")
    ReservationOutputDTO toDTO(Reservation reservationEntity);



    /**
     * This method update partially an entity with the DTO.
     *
     * @param reservationEntity The entity to updated.
     * @param reservationInputDTO The DTO.
     */
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "court", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Reservation reservationEntity, ReservationInputDTO reservationInputDTO);



    /**
     * This method update fully an entity with the DTO.
     *
     * @param reservationEntity The entity to updated.
     * @param reservationInputDTO The DTO.
     */
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "court", ignore = true)
    void fullUpdate(@MappingTarget Reservation reservationEntity, ReservationInputDTO reservationInputDTO);



    /**
     * This method converts a user into an id.
     *
     * @param userEntity The user.
     * @return Return the user's id.
     */
    default Integer map(User userEntity) {
        return userEntity == null ? null : userEntity.getId();
    }



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
