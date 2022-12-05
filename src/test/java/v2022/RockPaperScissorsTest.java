package v2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ReadInputUtil;

class RockPaperScissorsTest {

	RockPaperScissors rockPaperScissors;
	private ArrayList<String> testInput;

	@BeforeEach
	void setUp() {
		rockPaperScissors = new RockPaperScissors();
		testInput = new ArrayList<>();
		testInput.add("A Y");
		testInput.add("B X");
		testInput.add("C Z");
	}

	@Test
	void partOne() {
		ArrayList<RockPaperScissors.RPSRound> rpsRounds = rockPaperScissors.fillRounds(testInput);
		System.out.println(rpsRounds);

		int testResultOne = rockPaperScissors.getResultOne(testInput);
		System.out.println(testResultOne);

		int resultOne = rockPaperScissors.getResultOne(ReadInputUtil.readLines("rockPaperScissors"));
		System.out.println(resultOne);
	}

	@Test
	void partTwo() {
		int testResultTwo = rockPaperScissors.getResultTwo(testInput);
		System.out.println(testResultTwo);
		assertEquals(12, testResultTwo);

		int resultTwo = rockPaperScissors.getResultTwo(ReadInputUtil.readLines("rockPaperScissors"));
		System.out.println(resultTwo);
	}
}