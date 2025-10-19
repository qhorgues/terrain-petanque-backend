package org.group_1.terrain_petanque.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.group_1.terrain_petanque.dto.CourtDTO;
import org.group_1.terrain_petanque.entity.Coordinates;
import org.group_1.terrain_petanque.entity.Court;
import org.junit.jupiter.api.Test;

/**
 * This class tests the court mapper.
 */
public class CourtMapperTest {

    /**
     * This methods test the converstion: Court Entity => Court DTO.
     */
    @Test
    public void toDtoTest() {
        // Init
        Court court = new Court("namy", 15, new Coordinates("", ""));
        court.setDescription("This is a unit test.");

        // Test
        CourtDTO courtDTO = CourtMapper.INSTANCE.toDTO(court);

        // Assertion
        assertEquals(courtDTO.getId(), court.getId());
        assertEquals(courtDTO.getName(), court.getName());
        assertEquals(courtDTO.getCoordinatesId(), court.getCoordinates().getId());
        assertEquals(courtDTO.getQuantity(), court.getQuantity());
        assertEquals(courtDTO.getDescription(), court.getDescription());
    }



    /**
     * This methods test the converstion: Court DTO => Court Entity.
     */
    @Test
    public void toEntityTest() {
        // Init
        CourtDTO courtDTO = new CourtDTO(100, "", 100, "Hola!", 15);

        // Test
        Court court = CourtMapper.INSTANCE.toEntity(courtDTO);

        // Assertion
        assertEquals(court.getId(), null); // The mapper cannot access to the id for security reason (no setter). You need to past the id with the service.
        assertEquals(court.getName(), courtDTO.getName());
        assertEquals(court.getQuantity(), courtDTO.getQuantity());
        assertEquals(court.getDescription(), courtDTO.getDescription());
        assertEquals(court.getCoordinates(), null); // Technically the service need to do the job, but there are not service in this test, so the answer is always null.
    }



    /**
     * This method test the convertion of a coordinate into an id. 
     */
    @Test
    public void mapTest() {
        // Init
        Coordinates coordinates = new Coordinates("100", "1010");
        try {
            Field id = Coordinates.class.getDeclaredField("id");
            id.setAccessible(true);
            id.set(coordinates, 15);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Imposssible to access to the id.");
        }

        // Test
        Integer id = CourtMapper.INSTANCE.map(coordinates);

        // Assertion
        assertEquals(id, 15);
    }
    
}
