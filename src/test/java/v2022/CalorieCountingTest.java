package v2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ReadInputUtil;

class CalorieCountingTest {

	private CalorieCounting calorieCounting;
	private List<String> inputTest;
	private List<String> input;

	@BeforeEach
	void setUp() {
		calorieCounting = new CalorieCounting();
		inputTest = ReadInputUtil.getInputAsLineList("caloriesCountingTest");
		input = ReadInputUtil.getInputAsLineList("caloriesCounting");
	}

	@Test
	void partOne() {
		Integer resultOneTest = calorieCounting.getResultOne(inputTest);
		assertEquals(24000, resultOneTest);

		Integer resultOne = calorieCounting.getResultOne(input);
		System.out.println(resultOne);
	}


	@Test
	void getResultTwo() {
		assertEquals(45000, calorieCounting.getResultTwo(inputTest));
		System.out.println(calorieCounting.getResultTwo(input));
	}
}