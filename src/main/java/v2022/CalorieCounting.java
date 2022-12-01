package v2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalorieCounting {

	public Integer getResultOne(List<String> input) {
		Map<Integer, Integer> caloryPerElfMap = getCaloryPerElfMap(combineInput(input));
		return caloryPerElfMap.values().stream().max(Comparator.naturalOrder()).get();
	}

	public Integer getResultTwo(List<String> input) {
		Map<Integer, Integer> resultOne = getCaloryPerElfMap(combineInput(input));
		List<Integer> sortedCaloriesPerElf = resultOne.values().stream().sorted(Comparator.reverseOrder()).toList();
		return sortedCaloriesPerElf.get(0) + sortedCaloriesPerElf.get(1) + sortedCaloriesPerElf.get(2);
	}

	public Map<Integer, Integer> getCaloryPerElfMap(List<List<Integer>> input) {
		HashMap<Integer, Integer> map = new HashMap<>();
		input.forEach(list -> {
			map.put(input.indexOf(list), getCaloriesPerElf(list));
		});
		return map;
	}

	public List<List<Integer>> combineInput(List<String> input) {
		List<List<Integer>> total = new ArrayList<>();
		ArrayList<String> current = new ArrayList<>();
		for (String line : input) {
			if (line.isEmpty()) {
				total.add(mapToInteger(current));
				current = new ArrayList<>();
			} else {
				current.add(line);
			}
		}
		total.add(mapToInteger(current));
		return total;
	}

	private List<Integer> mapToInteger(ArrayList<String> initial) {
		return initial.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

	private Integer getCaloriesPerElf(List<Integer> input) {
		return input.stream().reduce(0, Integer::sum);
	}
}
