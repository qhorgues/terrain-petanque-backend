package com.polytech.terrainpetanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.polytech.terrainpetanque.dto.input.ReservationInputDTO;
import com.polytech.terrainpetanque.dto.mapper.ReservationMapper;
import com.polytech.terrainpetanque.dto.output.ReservationOutputDTO;
import com.polytech.terrainpetanque.entity.Reservation;
import com.polytech.terrainpetanque.entity.ReservationKey;
import com.polytech.terrainpetanque.repository.ReservationRepository;

import jakarta.transaction.Transactional;

/**
 * This class represent the service to handle a reservation.
 */
@Service
@Transactional
public class ReservationService {

    /**
     * This attribute represents the repository for the reservations.
     */
    private final ReservationRepository reservationRepository;



    /**
     * This attribute represents the mapper for the reservations.
     */
    private final ReservationMapper reservationMapper;



    /**
     * The constructor.
     *
     * @param reservationRepository The repository for the reservations.
     * @param reservationMapper The mapper for the reservations.
     */
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }



    /**
     * This methods add a reservation in the database.
     *
     * @param reservationInputDTO The reservation's informations.
     */
    @Modifying
    public ReservationOutputDTO addReservation(ReservationInputDTO reservationInputDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationInputDTO);
        return reservationMapper.toDTO(reservationRepository.save(reservation));
    }



    /**
     * This methods update partially a reservation in the database.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @param reservationInputDTO The reservation's informations.
     * @throws NotFoundException If the reservation are not in the database.
     */
    @Modifying
    public ReservationOutputDTO partialUpdateReservation(int userId, int courtId, ReservationInputDTO reservationInputDTO) throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional =
            reservationRepository.findById(reservationKey);

        if (reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Reservation reservation = reservationOptional.get();

        reservationMapper.partialUpdate(reservation, reservationInputDTO);

        return reservationMapper.toDTO(reservationRepository.save(reservation));
    }

    /**
     * This methods update fully a reservation in the database.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @param reservationInputDTO The reservation's informations.
     * @throws NotFoundException If the reservation are not in the database.
     */
    @Modifying
    public ReservationOutputDTO fullUpdateReservation(int userId, int courtId, ReservationInputDTO reservationInputDTO) throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional =
            reservationRepository.findById(reservationKey);

        if (reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Reservation reservation = reservationOptional.get();

        reservationMapper.fullUpdate(reservation, reservationInputDTO);

        return reservationMapper.toDTO(reservationRepository.save(reservation));
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
    public ReservationOutputDTO getReservation(int userId, int courtId)
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
    public List<ReservationOutputDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        List<ReservationOutputDTO> result = new ArrayList<>();

        for (Reservation reservation : reservations) {
            result.add(reservationMapper.toDTO(reservation));
        }

        return result;
    }

}
