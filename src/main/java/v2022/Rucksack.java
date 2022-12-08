package v2022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import common.TwoParts;

public class Rucksack implements TwoParts {

	@Override
	public int getPartOne(List<String> input) {
		return input.stream().map(this::getSharedItem).map(this::getPriority).reduce(Integer::sum).orElse(-1);
	}

	@Override
	public int getPartTwo(List<String> input) {
		List<List<String>> groups = Lists.partition(new ArrayList<>(input), 3);
		return groups.stream().map(this::getSharedGroupItem).map(this::getPriority).reduce(Integer::sum).orElse(-1);
	}

	public String getSharedItem(String rucksack) {
		int length = rucksack.length();
		String firstCompartment = rucksack.substring(0, length / 2);
		String secondCompartment = rucksack.substring(length / 2);
		HashSet<Object> set = new HashSet<>();

		Set<Character> firstSet = firstCompartment.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
		Set<Character> secondSet = secondCompartment.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

		List<String> sharedItem = firstSet.stream().filter(secondSet::contains).map(String::valueOf).toList();
		return sharedItem.get(0);
	}

	public String getSharedGroupItem(List<String> group) {
		List<Set<Character>> sets = group.stream()
				.map(elem -> elem.chars().mapToObj(e -> (char) e).collect(Collectors.toSet()))
				.toList();

		List<String> sharedItem = sets.get(0)
				.stream()
				.filter(sets.get(1)::contains)
				.filter(sets.get(2)::contains)
				.map(String::valueOf)
				.toList();
		return sharedItem.get(0);
	}

	public int getPriority(String sharedItem) {
		char[] chars = sharedItem.toCharArray();
		char aChar = chars[0];
		int offset = Character.isUpperCase(aChar) ? 38 : 96;
		return aChar - offset;
	}
}
