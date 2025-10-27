package org.group_1.terrain_petanque.entiy;

import org.group_1.terrain_petanque.entity.Coordinates;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Coordinates entity.
 */
public class CoordinatesTest {

    /**
     * This method tests the constructor.
     */
    @Test
    public void constructorTest() {
        try {
            new Coordinates("100", null);
            throw new RuntimeException("It cannot be possible to have a longitude with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }

        try {
            new Coordinates(null, "120");
            throw new RuntimeException("It cannot be possible to have a latitude with null");
        }
        catch (NullPointerException exception) {
            // The constrain is a success.
        }
    }


}
