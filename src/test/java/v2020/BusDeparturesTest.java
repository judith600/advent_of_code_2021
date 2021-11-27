package v2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BusDeparturesTest {

    private BusDepartures busDepartures;

    @BeforeEach
    void setUp() {
        busDepartures = new BusDepartures();
    }

    @Test
    void getBusDepartures() {
        ArrayList<BusDepartures.BusAndOffset> busAndOffsets = busDepartures
                .getBusDepartures("17,x,13,19");
        Assertions.assertEquals(new BusDepartures.BusAndOffset(1, 17), busAndOffsets.get(0));
        Assertions.assertEquals(new BusDepartures.BusAndOffset(2, 13), busAndOffsets.get(1));
        Assertions.assertEquals(new BusDepartures.BusAndOffset(1, 19), busAndOffsets.get(2));
        System.out.println(busAndOffsets);
    }

    @Test
    void getCorrectFactor() {
    }

    @Test
    void isValidFactor() {
    }
}