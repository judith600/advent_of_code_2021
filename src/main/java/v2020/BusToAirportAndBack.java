package v2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BusToAirportAndBack {

    private int personalDeparture;
    private Integer finalBusId;
    private Integer finalDifference = null;

    public int doWork(String input) {
        getBusDepartures(input).forEach(busId -> {
            int newDifference = getDifference(busId);
            assignBestBusIdIfSmaller(newDifference, busId);
        });
        return finalBusId;
    }

    public List<Integer> getBusDepartures(String input) {
        List<String> stringList = Arrays.asList(input.split(","));
        return stringList
                .stream()
                .filter(elem -> !elem.equalsIgnoreCase("x"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int getDifference(int busId) {
        int moduloRest = personalDeparture % busId;
        return busId - moduloRest;
    }

    public void assignBestBusIdIfSmaller(int number, int busId) {
        if (finalDifference == null || finalDifference > number) {
            finalDifference = number;
            finalBusId = busId;
        }
    }

    public Integer getFinalDifference() {
        return finalDifference;
    }

    public void setPersonalDeparture(int number) {
        personalDeparture = number;
    }

}
