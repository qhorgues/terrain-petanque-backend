package org.group_1.terrain_petanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.group_1.terrain_petanque.dto.CoordinatesDTO;
import org.group_1.terrain_petanque.dto.mapper.CoordinatesMapper;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * This class represent the service to handle coordinates.
 */
@Service
@Transactional
public class CoordinatesService {

    /**
     * This attribute represents the repository.
     */
    private final CoordinatesRepository coordinatesRepository;



    /**
     * The constructor.
     * 
     * @param coordinatesRepository The repository.
     */
    @Autowired
    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }



    /**
     * This methods add coordinates in the database.
     * 
     * @param coordinatesDTO The coordinates' informations.
     */
    @Modifying
    public void addCoordinates(CoordinatesDTO coordinatesDTO) {
        Coordinates coordinates = CoordinatesMapper.INSTANCE.toEntity(coordinatesDTO);
        coordinatesRepository.save(coordinates);
    }



    /**
     * This methods update coordinates in the database.
     * 
     * @param id The coordinates' id.
     * @param coordinatesDTO The coordinates' informations.
     * @throws NotFoundException If the coordinates are not in the database.
     */
    @Modifying
    public void updateCoordinates(int id, CoordinatesDTO coordinatesDTO) throws NotFoundException {
        Optional<Coordinates> coordinatesOptional = coordinatesRepository.findById(id);

        if (coordinatesOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Coordinates coordinates = coordinatesOptional.get();

        CoordinatesMapper.INSTANCE.update(coordinates, coordinatesDTO);

        coordinatesRepository.save(coordinates);
    }



    /**
     * This methods delete coordinates in the database.
     * 
     * @param id The coordinates' id.
     */
    @Modifying
    public void deleteCoordinates(int id) {
        coordinatesRepository.deleteById(id);
    }



    /**
     * This method get a specific coordinates.
     * 
     * @param id The coordinates' id.
     * @return Return the coordinates' informations.
     * @throws NotFoundException If the coordinates are not in the database.
     */
    public CoordinatesDTO getCoordinates(int id) throws NotFoundException {
        Optional<Coordinates> coordinatesOptional = coordinatesRepository.findById(id);

        if (coordinatesOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Coordinates coordinates = coordinatesOptional.get();

        return CoordinatesMapper.INSTANCE.toDTO(coordinates);
    }



    /**
     * This method get all coordinates.
     * 
     * @return Return all the coordinates.
     */
    public List<CoordinatesDTO> getAllCoordinates() {
        List<Coordinates> coordinates = coordinatesRepository.findAll();

        List<CoordinatesDTO> result = new ArrayList<>();

        for (Coordinates coordinate : coordinates) {
            result.add(CoordinatesMapper.INSTANCE.toDTO(coordinate));
        }

        return result;
    }

}
