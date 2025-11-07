package org.group_1.terrain_petanque.service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.group_1.terrain_petanque.dto.CourtDTO;
import org.group_1.terrain_petanque.dto.mapper.CourtMapper;
import org.group_1.terrain_petanque.entity.Court;
import org.group_1.terrain_petanque.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 * This class represent the service to handle a court.
 */
@Service
@Transactional
public class CourtService {

    /**
     * This attribute is the repository.
     */
    private final CourtRepository courtRepository;

    private final CourtMapper courtMapper;

    /**
     * The constructor.
     *
     * @param courtRepository The repository.
     */
    @Autowired
    public CourtService(CourtRepository courtRepository, CourtMapper courtMapper) {
        this.courtRepository = courtRepository;
        this.courtMapper = courtMapper;
    }

    /**
     * This methods add a court in the database.
     *
     * @param courtDTO The court's informations.
     */
    @Modifying
    public CourtDTO addCourt(CourtDTO courtDTO) {
        Court court = courtMapper.toEntity(courtDTO);
        return courtMapper.toDTO(courtRepository.save(court));
    }

    /**
     * This methods update a court in the database.
     *
     * @param id The court's id.
     * @param courtDTO The court's informations.
     * @throws NotFoundException If the court are not in the database.
     */
    @Modifying
    public CourtDTO updateCourt(int id, CourtDTO courtDTO)
        throws NotFoundException {
        Optional<Court> courtOptional = courtRepository.findById(id);

        if (courtOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Court court = courtOptional.get();

        courtMapper.update(court, courtDTO);

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
    public CourtDTO getCourt(int id) throws NotFoundException {
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
    public List<CourtDTO> getAllCourts() {
        List<Court> courts = courtRepository.findAll();

        List<CourtDTO> result = new ArrayList<>();

        for (Court court : courts) {
            result.add(courtMapper.toDTO(court));
        }

        return result;
    }
}
