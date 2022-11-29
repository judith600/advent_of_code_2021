package v2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ReadInputUtil;

class BinaryDiagnosticTest {

	private BinaryDiagnostic binaryDiagnostic;

	@BeforeEach
	void setUp() {
		binaryDiagnostic = new BinaryDiagnostic();
	}

	@Test
	void checkTestResult() {
		List<String> testNumbers = List.of("00100",
				"11110",
				"10110",
				"10111",
				"10101",
				"01111",
				"00111",
				"11100",
				"10000",
				"11001",
				"00010",
				"01010");
		assertEquals(198, binaryDiagnostic.getResultOne(testNumbers));
	}

	@Test
	void getResultOne() {
		System.out.println(binaryDiagnostic.getResultOne(ReadInputUtil.readLines("binaryDiagnostic")));
	}
}
