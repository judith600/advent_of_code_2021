package v2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BusToAirportAndBack {

    private int personalDeparture;
    private ArrayList<String> busDepartures;
    private Integer finalDifference = null;

    public int doWork(String input) {
        getBusDepartures(input).forEach(number -> {
            int newDifference = getDifference(number);
            assignFinalDifferenceIfSmaller(newDifference);
        });
        return finalDifference;
    }

    public List<Integer> getBusDepartures(String input) {
        List<String> stringList = Arrays.asList(input.split(","));
        return stringList
                .stream()
                .filter(elem -> !elem.equalsIgnoreCase("x"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int getDifference(int number) {
        return personalDeparture % number;
    }

    public void assignFinalDifferenceIfSmaller(int number) {
        if (finalDifference == null || finalDifference > number) {
            finalDifference = number;
        }
    }

}
