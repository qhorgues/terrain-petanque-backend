package org.group_1.terrain_petanque.service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.group_1.terrain_petanque.dto.ReservationDTO;
import org.group_1.terrain_petanque.dto.mapper.ReservationMapper;
import org.group_1.terrain_petanque.entity.Reservation;
import org.group_1.terrain_petanque.entity.ReservationKey;
import org.group_1.terrain_petanque.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 * This class represent the service to handle a reservation.
 */
@Service
@Transactional
public class ReservationService {

    /**
     * This attribute is the repository.
     */
    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    /**
     * The constructor.
     *
     * @param reservationRepository The repository.
     */
    @Autowired
    public ReservationService(
        ReservationRepository reservationRepository,
        ReservationMapper reservationMapper
    ) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    /**
     * This methods add a reservation in the database.
     *
     * @param reservationDTO The reservation's informations.
     */
    @Modifying
    public void addReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        reservationRepository.save(reservation);
    }

    /**
     * This methods update a reservation in the database.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @param reservationDTO The reservation's informations.
     * @throws NotFoundException If the reservation are not in the database.
     */
    @Modifying
    public void updateReservation(
        int userId,
        int courtId,
        ReservationDTO reservationDTO
    ) throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional =
            reservationRepository.findById(reservationKey);

        if (reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Reservation reservation = reservationOptional.get();

        reservationMapper.update(reservation, reservationDTO);

        reservationRepository.save(reservation);
    }

    /**
     * This methods delete a reservation in the database.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     */
    @Modifying
    public void deleteReservation(int userId, int courtId) {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        reservationRepository.deleteById(reservationKey);
    }

    /**
     * This method get a specific reservation.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @return Return the reservation's informations.
     * @throws NotFoundException If the reservation are not in the database.
     */
    public ReservationDTO getReservation(int userId, int courtId)
        throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional =
            reservationRepository.findById(reservationKey);

        if (reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Reservation reservation = reservationOptional.get();

        return reservationMapper.toDTO(reservation);
    }

    /**
     * This method get all reservations.
     *
     * @return Return all the reservations.
     */
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationDTO> result = new ArrayList<>();

        for (Reservation reservation : reservations) {
            result.add(reservationMapper.toDTO(reservation));
        }

        return result;
    }
}
