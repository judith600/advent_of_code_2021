package v2021;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

public class BinaryDiagnostic {

	public int getResultOne(List<String> input) {
		String gammaRate = getGammaRate(input);
		String epsilonRate = getEpsilonRate(gammaRate);

		int gammaRateDecimal = Integer.parseInt(gammaRate, 2);
		int epsilonRateDecimal = Integer.parseInt(epsilonRate, 2);
		return gammaRateDecimal * epsilonRateDecimal;
	}

	public String getGammaRate(List<String> input) {
		int halfSize = input.size() / 2;
		int length = input.get(0).length();

		StringBuilder builder = new StringBuilder();

		IntStream.range(0, length).forEach(index -> {
			int ones = 0;
			for (String number : input) {
				if (Integer.parseInt(String.valueOf(number.charAt(index))) == 1) {
					ones++;
				}
			}
			if (ones > halfSize) {
				builder.append("1");
			} else {
				builder.append("0");
			}
		});

		return builder.toString();
	}

	public String getEpsilonRate(String gammaRate) {
		return StringUtils.replaceChars(gammaRate, "01", "10");
	}

	public int getResultTwo() {
		int oxygenGenerator = getOxygenGenerator();
		int co2Scrubber = getCo2Scrubber();
		return oxygenGenerator * co2Scrubber;
	}

	private int getCo2Scrubber() {
		return 0;
	}

	private int getOxygenGenerator() {
		return 0;
	}

}
