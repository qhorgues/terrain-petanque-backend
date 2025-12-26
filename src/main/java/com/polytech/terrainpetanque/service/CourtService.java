package com.polytech.terrainpetanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.polytech.terrainpetanque.dto.input.CourtInputDTO;
import com.polytech.terrainpetanque.dto.mapper.CourtMapper;
import com.polytech.terrainpetanque.dto.output.CourtOutputDTO;
import com.polytech.terrainpetanque.entity.Court;
import com.polytech.terrainpetanque.repository.CourtRepository;

import jakarta.transaction.Transactional;

/**
 * This class represent the service to handle a court.
 */
@Service
@Transactional
public class CourtService {

    /**
     * This attribute represents the repository for the courts.
     */
    private final CourtRepository courtRepository;



    /**
     * This attribute represents the mapper for the courts.
     */
    private final CourtMapper courtMapper;



    /**
     * The constructor.
     *
     * @param courtRepository The repository for the courts.
     * @param courtMapper The mapper for the courts.
     */
    @Autowired
    public CourtService(CourtRepository courtRepository, CourtMapper courtMapper) {
        this.courtRepository = courtRepository;
        this.courtMapper = courtMapper;
    }



    /**
     * This methods add a court in the database.
     *
     * @param courtInputDTO The court's informations.
     */
    @Modifying
    public CourtOutputDTO addCourt(CourtInputDTO courtInputDTO) {
        Court court = courtMapper.toEntity(courtInputDTO);
        return courtMapper.toDTO(courtRepository.save(court));
    }



    /**
     * This methods update partially a court in the database.
     *
     * @param id The court's id.
     * @param courtInputDTO The court's informations.
     * @throws NotFoundException If the court are not in the database.
     */
    @Modifying
    public CourtOutputDTO partialUpdateCourt(int id, CourtInputDTO courtInputDTO)
        throws NotFoundException {
        Optional<Court> courtOptional = courtRepository.findById(id);

        if (courtOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Court court = courtOptional.get();

        courtMapper.partialUpdate(court, courtInputDTO);

        return courtMapper.toDTO(courtRepository.save(court));
    }



    /**
     * This methods update fully a court in the database.
     *
     * @param id The court's id.
     * @param courtInputDTO The court's informations.
     * @throws NotFoundException If the court are not in the database.
     */
    @Modifying
    public CourtOutputDTO fullUpdateCourt(int id, CourtInputDTO courtInputDTO)
        throws NotFoundException {
        Optional<Court> courtOptional = courtRepository.findById(id);

        if (courtOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Court court = courtOptional.get();

        courtMapper.fullUpdate(court, courtInputDTO);

        return courtMapper.toDTO(courtRepository.save(court));
    }



    /**
     * This methods delete a court in the database.
     *
     * @param id The court's id.
     */
    @Modifying
    public void deleteCourt(int id) {
        courtRepository.deleteById(id);
    }



    /**
     * This method get a specific court.
     *
     * @param id The court's id.
     * @return Return the court's informations.
     * @throws NotFoundException If the court are not in the database.
     */
    public CourtOutputDTO getCourt(int id) throws NotFoundException {
        Optional<Court> courtOptional = courtRepository.findById(id);

        if (courtOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Court court = courtOptional.get();

        return courtMapper.toDTO(court);
    }



    /**
     * This method get all courts.
     *
     * @return Return all the courts.
     */
    public List<CourtOutputDTO> getAllCourts() {
        List<Court> courts = courtRepository.findAll();

        List<CourtOutputDTO> result = new ArrayList<>();

        for (Court court : courts) {
            result.add(courtMapper.toDTO(court));
        }

        return result;
    }

}
