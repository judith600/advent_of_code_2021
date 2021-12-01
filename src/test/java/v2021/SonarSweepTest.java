package v2021;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SonarSweepTest {

	private SonarSweep sonarSweep;

	@BeforeEach
	public void setup() {
		sonarSweep = new SonarSweep();
	}

	@Test
	public void testGetInput() throws IOException {
		String input = sonarSweep.getRawInput();
		List<Integer> formattedInput = sonarSweep.getFormattedInput(input);
		int biggerNumberCount = sonarSweep.doWork(formattedInput);
		System.out.println(biggerNumberCount);
	}

	@Test
	public void slidingWindow() throws IOException {
		int biggerNumberCount = sonarSweep.doSlidingWindow(sonarSweep.getFormattedInput(sonarSweep.getRawInput()));
		System.out.println(biggerNumberCount);
	}

	@Test
	public void testExample() {
		int doWork = sonarSweep.doWork(sonarSweep.getFormattedInput("199,200,208,210,200,207,240,269,260,263"));
		System.out.println(doWork);

		int slidingWindow = sonarSweep.doSlidingWindow(sonarSweep.getFormattedInput("199,200,208,210,200,207,240,269,260,263"));
		System.out.println(slidingWindow);
	}

}