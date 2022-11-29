package v2021;

import java.util.Arrays;
import java.util.List;

import common.ReadInputUtil;

public class Dive {

    public List<String> getInput() {
        String rawInput = ReadInputUtil.getInputAsCommaSeparatedString("dive.txt");
        return Arrays.asList(rawInput.split(","));
    }

    public int doWork(List<String> input) {
        int horizontal = 0;
        int depth = 0;
        for (String command : input) {
            List<String> commandList = Arrays.asList(command.split(" "));
            String direction = commandList.get(0);
            int amount = Integer.parseInt(commandList.get(1));
            if (direction.equalsIgnoreCase("forward")) {
                horizontal += amount;
            } else if (direction.equalsIgnoreCase("up")) {
                depth -= amount;
            } else if (direction.equalsIgnoreCase("down")) {
                depth += amount;
            }
        }
        return horizontal * depth;
    }

    public int doWorkWithAim(List<String> input) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (String command : input) {
            List<String> commandList = Arrays.asList(command.split(" "));
            String direction = commandList.get(0);
            int amount = Integer.parseInt(commandList.get(1));
            if (direction.equalsIgnoreCase("forward")) {
                horizontal += amount;
                depth += aim * amount;
            } else if (direction.equalsIgnoreCase("up")) {
                aim -= amount;
            } else if (direction.equalsIgnoreCase("down")) {
                aim += amount;
            }
        }
        return horizontal * depth;
    }
}
