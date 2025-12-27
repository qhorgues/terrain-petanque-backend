package com.polytech.terrainpetanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.polytech.terrainpetanque.dto.input.ReservationInputDTO;
import com.polytech.terrainpetanque.dto.mapper.ReservationMapper;
import com.polytech.terrainpetanque.dto.output.ReservationOutputDTO;
import com.polytech.terrainpetanque.entity.Court;
import com.polytech.terrainpetanque.entity.Reservation;
import com.polytech.terrainpetanque.entity.ReservationKey;
import com.polytech.terrainpetanque.entity.User;
import com.polytech.terrainpetanque.repository.CourtRepository;
import com.polytech.terrainpetanque.repository.ReservationRepository;
import com.polytech.terrainpetanque.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * This class represent the service to handle the reservations.
 */
@RequiredArgsConstructor
@Service
@Transactional
public class ReservationService {

    /**
     * This attribute represents the repository for the reservations.
     */
    private final ReservationRepository reservationRepository;



    /**
     * This attribute represents the repository for the users.
     */
    private final UserRepository userRepository;



    /**
     * This attribute represents the repository for the courts.
     */
    private final CourtRepository courtRepository;



    /**
     * This attribute represents the mapper for the reservations.
     */
    private final ReservationMapper reservationMapper;



    /**
     * This method creates a reservation in the database.
     *
     * @param userId The user's id for the reservation.
     * @param courtId The court's id for the reservation.
     * @param reservationInputDTO The reservation's informations.
     * @return Return the reservation created.
     * @throws NotFoundException If the user or the court doesn't exist.
     */
    @Modifying
    public ReservationOutputDTO createReservation(int userId, int courtId, ReservationInputDTO reservationInputDTO) throws NotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NotFoundException();
        }
        User user = userOptional.get();

        Optional<Court> courtOptional = courtRepository.findById(courtId);
        if (courtOptional.isEmpty()) {
            throw new NotFoundException();
        }
        Court court = courtOptional.get();

        Reservation reservation = reservationMapper.toEntity(reservationInputDTO);
        reservation.setUser(user);
        reservation.setCourt(court);

        return reservationMapper.toDTO(reservationRepository.save(reservation));
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



    /**
     * This method get a specific reservation.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @return Return the reservation.
     * @throws NotFoundException If the reservation are not in the database.
     */
    public ReservationOutputDTO getReservation(int userId, int courtId) throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationKey);

        if (reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Reservation reservation = reservationOptional.get();

        return reservationMapper.toDTO(reservation);
    }



    /**
     * This method updates partially a reservation in the database.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @param reservationInputDTO The reservation's informations.
     * @return Return the updated reservation.
     * @throws NotFoundException If the reservation are not in the database.
     */
    @Modifying
    public ReservationOutputDTO partialUpdateReservation(int userId, int courtId, ReservationInputDTO reservationInputDTO) throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationKey);

        if (reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Reservation reservation = reservationOptional.get();

        reservationMapper.partialUpdate(reservation, reservationInputDTO);

        return reservationMapper.toDTO(reservationRepository.save(reservation));
    }



    /**
     * This method updates fully a reservation in the database.
     *
     * @param userId The user's id in the reservation.
     * @param courtId The court's id in the reservation.
     * @param reservationInputDTO The reservation's informations.
     * @return Return the updated reservation.
     * @throws NotFoundException If the reservation are not in the database.
     */
    @Modifying
    public ReservationOutputDTO fullUpdateReservation(int userId, int courtId, ReservationInputDTO reservationInputDTO) throws NotFoundException {
        ReservationKey reservationKey = new ReservationKey(userId, courtId);
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationKey);

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

}
