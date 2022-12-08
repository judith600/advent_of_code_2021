package v2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ReadInputUtil;

class RucksackTest {

	private Rucksack rucksack;

	private List<String> testInput;

	@BeforeEach
	void setUp() {
		rucksack = new Rucksack();
		testInput = ReadInputUtil.readLines("rucksackTest");
	}

	@Test
	void name() {
		assertEquals("p", rucksack.getSharedItem(testInput.get(0)));
		assertEquals("L", rucksack.getSharedItem(testInput.get(1)));
		assertEquals("P", rucksack.getSharedItem(testInput.get(2)));
		assertEquals("v", rucksack.getSharedItem(testInput.get(3)));
		assertEquals("t", rucksack.getSharedItem(testInput.get(4)));
		assertEquals("s", rucksack.getSharedItem(testInput.get(5)));

		assertEquals(1, rucksack.getPriority("a"));
		assertEquals(27, rucksack.getPriority("A"));
		assertEquals(38, rucksack.getPriority("L"));
		assertEquals(22, rucksack.getPriority("v"));

		assertEquals(157, rucksack.getPartOne(testInput));

		System.out.println(rucksack.getPartOne(Objects.requireNonNull(ReadInputUtil.readLines("rucksack"))));
	}

	@Test
	public void partTwo() {
		assertEquals("r",
				rucksack.getSharedGroupItem(
						List.of("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg")));

		assertEquals("Z",
				rucksack.getSharedGroupItem(
						List.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw")));

		System.out.println(rucksack.getPartTwo(Objects.requireNonNull(ReadInputUtil.readLines("rucksack"))));
	}
}
