package v2020;

import java.util.*;

public class BusDepartures {

    public record BusAndOffset(Integer offSet, Integer busId) {}

    public ArrayList<BusAndOffset> getBusDepartures(String input) {
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(input.split(",")));

        ArrayList<BusAndOffset> busAndOffsets = new ArrayList<>();
        int offsetCounter = 1;
        for (String elem : stringList) {
            if ("x".equalsIgnoreCase(elem)) {
                offsetCounter++;
            } else {
                busAndOffsets.add(new BusAndOffset(offsetCounter, Integer.valueOf(elem)));
                offsetCounter = 1;
            }
        }
        return busAndOffsets;
    }

    public int getCorrectFactor(ArrayList<BusAndOffset> busAndOffsets) {
        int number = 0;
        boolean isValid = false;
        do {
            isValid = isValidFactor(number, busAndOffsets);
            if (isValid) {
                return number;
            }
            number++;
        } while (true);
    }

    public boolean isValidFactor(int factor, ArrayList<BusAndOffset> busAndOffsets) {
        for (BusAndOffset first : busAndOffsets) {
            BusAndOffset second = busAndOffsets.get(busAndOffsets.indexOf(first) + 1);
            Integer neededOffset = second.offSet;
            int realOffset = second.busId * factor - first.busId * factor;
            if (realOffset != neededOffset) {
                return false;
            }
        }
        return true;
    }
}
