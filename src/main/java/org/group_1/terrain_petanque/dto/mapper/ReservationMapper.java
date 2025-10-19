package org.group_1.terrain_petanque.dto.mapper;

import org.group_1.terrain_petanque.dto.ReservationDTO;
import org.group_1.terrain_petanque.entity.Court;
import org.group_1.terrain_petanque.entity.Reservation;
import org.group_1.terrain_petanque.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * This interface representer a mapper (ReservationDTO <=> Reservation).
 */
@Mapper(componentModel = "spring")
public interface ReservationMapper {

    /**
     * This field represents an instance of the mapper.
     */
    final ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);



    /**
     * This method converts a reservation DTO into a reservation Entity.
     * 
     * @param reservationDTO The reservation DTO.
     * @return Return the reservation Entity.
     */
    @Mappings({
        @Mapping(target = "user", ignore = true),
        @Mapping(target = "court", ignore = true)
    })
    Reservation toEntity(ReservationDTO reservationDTO);



    /**
     * This method converts a reservation Entity into a reservation DTO.
     * 
     * @param reservationEntity The reservation Entity.
     * @return Return the reservation DTO.
     */
    @Mappings({
        @Mapping(source = "user", target = "userId"),
        @Mapping(source = "court", target = "courtId")
    })
    ReservationDTO toDTO(Reservation reservationEntity);



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
