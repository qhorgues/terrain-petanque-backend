package org.group_1.terrain_petanque.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.group_1.terrain_petanque.dto.CoordinatesDTO;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.junit.jupiter.api.Test;

/**
 * This class tests the coordinates mapper.
 */
public class CoordinatesMapperTest {
    
    /**
     * This methods test the converstion: Coordinates Entity => Coordinates DTO.
     */
    @Test
    public void toDtoTest() {
        // Init
        Coordinates coordinates = new Coordinates("180", "160");

        // Test
        CoordinatesDTO coordinatesDTO = CoordinatesMapper.INSTANCE.toDTO(coordinates);

        // Assertion
        assertEquals(coordinatesDTO.getId(), coordinates.getId());
        assertEquals(coordinatesDTO.getLatitude(), coordinates.getLatitude());
        assertEquals(coordinatesDTO.getLongitude(), coordinates.getLongitude());
        assertEquals(coordinatesDTO.getCourtsId().size(), 0);
    }



    /**
     * This methods test the converstion: Coordinates DTO => Coordinates Entity.
     */
    @Test
    public void toEntityTest() {
        // Init
        Set<Integer> courts = new HashSet<>();
        courts.add(10);
        courts.add(20);
        CoordinatesDTO coordinatesDTO = CoordinatesDTO.builder().latitude("100").longitude("120").id(10).courtsId(courts).build();

        // Test
        Coordinates coordinates = CoordinatesMapper.INSTANCE.toEntity(coordinatesDTO);

        // Assertion
        assertEquals(coordinates.getId(), null); // The mapper cannot access to the id for security reason (no setter). You need to past the id with the service.
        assertEquals(coordinates.getLatitude(), coordinatesDTO.getLatitude());
        assertEquals(coordinates.getLongitude(), coordinatesDTO.getLongitude());
        assertEquals(coordinates.getCourts().size(), 2);
    }



    /**
     * This method test the convertion of a court into an id. 
     */
    @Test
    public void mapTest() {
        // Init
        Court court = new Court("Salut", 10, new Coordinates("100", "1200"));
        try {
            Field id = Court.class.getDeclaredField("id");
            id.setAccessible(true);
            id.set(court, 15);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Imposssible to access to the id.");
        }

        // Test
        Integer id = CoordinatesMapper.INSTANCE.map(court);

        // Assertion
        assertEquals(id, 15);
    }

}
