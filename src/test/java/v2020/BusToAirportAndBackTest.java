package v2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusToAirportAndBackTest {

    private BusToAirportAndBack bus;

    @BeforeEach
    public void setUp() {
        bus = new BusToAirportAndBack();
    }

    @Test
    void doWork() {
    }

    @Test
    void getBusDepartures() {
        bus.getBusDepartures("");
    }

    @Test
    void getDifference() {
    }

    @Test
    void assignFinalDifferenceIfSmaller() {
    }
}