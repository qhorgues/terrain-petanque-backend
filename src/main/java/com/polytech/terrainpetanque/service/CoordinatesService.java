package com.polytech.terrainpetanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.polytech.terrainpetanque.dto.input.CoordinatesInputDTO;
import com.polytech.terrainpetanque.dto.mapper.CoordinatesMapper;
import com.polytech.terrainpetanque.dto.output.CoordinatesOutputDTO;
import com.polytech.terrainpetanque.entity.Coordinates;
import com.polytech.terrainpetanque.repository.CoordinatesRepository;

import jakarta.transaction.Transactional;

/**
 * This class represent the service to handle coordinates.
 */
@Service
@Transactional
public class CoordinatesService {

    /**
     * This attribute represents the repository for coordinates.
     */
    private final CoordinatesRepository coordinatesRepository;


    /**
     * This attribute represents the mapper for the coordinates.
     */
    private final CoordinatesMapper coordinatesMapper;



    /**
     * The constructor.
     *
     * @param coordinatesRepository The repository for the coordinates.
     * @param coordinatesMapper The mapper for the coordinates.
     */
    @Autowired
    public CoordinatesService(CoordinatesRepository coordinatesRepository, CoordinatesMapper coordinatesMapper) {
        this.coordinatesRepository = coordinatesRepository;
        this.coordinatesMapper = coordinatesMapper;
    }



    /**
     * This methods add coordinates in the database.
     *
     * @param coordinatesInputDTO The coordinates' informations.
     */
    @Modifying
    public CoordinatesOutputDTO addCoordinates(CoordinatesInputDTO coordinatesInputDTO) {
        Coordinates coordinates = coordinatesMapper.toEntity(coordinatesInputDTO);
        return coordinatesMapper.toDTO(coordinatesRepository.save(coordinates));
    }



    /**
     * This methods update partially coordinates in the database.
     *
     * @param id The coordinates' id.
     * @param coordinatesInputDTO The coordinates' informations.
     * @throws NotFoundException If the coordinates are not in the database.
     */
    @Modifying
    public CoordinatesOutputDTO partialUpdateCoordinates(int id, CoordinatesInputDTO coordinatesInputDTO) throws NotFoundException {
        Optional<Coordinates> coordinatesOptional =
            coordinatesRepository.findById(id);

        if (coordinatesOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Coordinates coordinates = coordinatesOptional.get();

        coordinatesMapper.partialUpdate(coordinates, coordinatesInputDTO);

        return coordinatesMapper.toDTO(coordinatesRepository.save(coordinates));
    }



    /**
     * This methods update fully coordinates in the database.
     *
     * @param id The coordinates' id.
     * @param coordinatesInputDTO The coordinates' informations.
     * @throws NotFoundException If the coordinates are not in the database.
     */
    @Modifying
    public CoordinatesOutputDTO fullUpdateCoordinates(int id, CoordinatesInputDTO coordinatesInputDTO) throws NotFoundException {
        Optional<Coordinates> coordinatesOptional =
            coordinatesRepository.findById(id);

        if (coordinatesOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Coordinates coordinates = coordinatesOptional.get();

        coordinatesMapper.fullUpdate(coordinates, coordinatesInputDTO);

        return coordinatesMapper.toDTO(coordinatesRepository.save(coordinates));
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
    public CoordinatesOutputDTO getCoordinates(int id) throws NotFoundException {
        Optional<Coordinates> coordinatesOptional =
            coordinatesRepository.findById(id);

        if (coordinatesOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Coordinates coordinates = coordinatesOptional.get();

        return coordinatesMapper.toDTO(coordinates);
    }



    /**
     * This method get all coordinates.
     *
     * @return Return all the coordinates.
     */
    public List<CoordinatesOutputDTO> getAllCoordinates() {
        List<Coordinates> coordinates = coordinatesRepository.findAll();

        List<CoordinatesOutputDTO> result = new ArrayList<>();

        for (Coordinates coordinate : coordinates) {
            result.add(coordinatesMapper.toDTO(coordinate));
        }

        return result;
    }

}
