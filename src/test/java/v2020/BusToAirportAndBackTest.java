package v2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BusToAirportAndBackTest {

    private BusToAirportAndBack bus;

    @BeforeEach
    public void setUp() {
        bus = new BusToAirportAndBack();
    }

    @Test
    void doWork() {
        // bus.setPersonalDeparture(939);
        // int bestBusId = bus.doWork("7,13,x,x,59,x,31,19");
        // Assertions.assertEquals(59, bestBusId);

        bus.setPersonalDeparture(1003240);
        int result = bus.doWork("19,x,x,x,x,x,x,x,x,41,x,x,x,37,x,x,x,x,x,787,x,x,x,x,x,x,x,x,x,x,x,x,13,x,x,x,x,x,x,x,x,x,23,x,x,x,x,x,29,x,571,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,17");
        int realResult = result * bus.getFinalDifference();
        System.out.println(realResult);
    }

    @Test
    void getBusDepartures() {
        Assertions.assertEquals(List.of(7,13,59,31,19),bus.getBusDepartures("7,13,x,x,59,x,31,19"));
    }

    @Test
    void getDifference() {
        bus.setPersonalDeparture(939);
        int difference = bus.getDifference(7);
        Assertions.assertEquals(6, difference);
    }

    @Test
    void assignFinalDifferenceIfSmaller() {
        Assertions.assertNull(bus.getFinalDifference());
        bus.assignBestBusIdIfSmaller(3, 17);
        Assertions.assertEquals(3, bus.getFinalDifference());

        bus.assignBestBusIdIfSmaller(5, 18);
        Assertions.assertEquals(3, bus.getFinalDifference());

        bus.assignBestBusIdIfSmaller(2, 19);
        Assertions.assertEquals(2, bus.getFinalDifference());
    }
}