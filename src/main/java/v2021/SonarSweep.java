package v2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SonarSweep {

	public String getRawInput() throws IOException {
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("sonarsweep.txt");
		assert resourceAsStream != null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
		StringBuilder stringBuilder = new StringBuilder();
		while (bufferedReader.ready()) {
			stringBuilder.append(bufferedReader.readLine()).append(",");
		}
		return stringBuilder.toString();
	}

	public List<Integer> getFormattedInput(String rawInput) {
		return Arrays.stream(rawInput.split(",")).map(Integer::valueOf).collect(Collectors.toList());
	}

	public int doWork(List<Integer> formattedInput) {
		int biggerNumberCount = 0;
		for(int i = 0; i < formattedInput.size(); i++) {
			if (i == 0) {
				// do nothing bc first element
			} else if (formattedInput.get(i) > formattedInput.get(i - 1)) {
//				System.out.println("previous number: " + formattedInput.get(i - 1) + " - current number: " + formattedInput.get(i));
				biggerNumberCount++;
			}
		}
		return biggerNumberCount;
	}

	public int doSlidingWindow(List<Integer> input) {
		int biggerNumberCount = 0;
		for(int i = 0; i < input.size() - 3; i++) {
			int window = input.get(i) + input.get(i + 1) + input.get(i + 2);
			int nextWindow = input.get(i+1) + input.get(i+2) + input.get(i+3);
			if (nextWindow > window) {
				biggerNumberCount++;
			}
		}
		return biggerNumberCount;
	}
}
