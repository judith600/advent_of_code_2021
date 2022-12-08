package v2022;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ReadInputUtil;

class CampCleanupTest {

	private CampCleanup campCleanup;
	private List<String> testInput;

	@BeforeEach
	void setUp() {
		campCleanup = new CampCleanup();
		testInput = List.of("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8");

	}

	@Test
	void getPartOne() {
		assertEquals(2, campCleanup.getPartOne(testInput));
		System.out.println(campCleanup.getPartOne(Objects.requireNonNull(ReadInputUtil.readLines("campCleanup"))));
	}

	@Test
	void getPartTwo() {
		assertEquals(4, campCleanup.getPartTwo(testInput));
		System.out.println(campCleanup.getPartTwo(Objects.requireNonNull(ReadInputUtil.readLines("campCleanup"))));
	}
}
