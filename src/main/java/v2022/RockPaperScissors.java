package v2022;

import static v2022.RockPaperScissors.Shape.PAPER;
import static v2022.RockPaperScissors.Shape.ROCK;
import static v2022.RockPaperScissors.Shape.SCISSOR;

import java.util.ArrayList;
import java.util.List;

public class RockPaperScissors {

	public int getResultOne(List<String> input) {
		ArrayList<RPSRound> rpsRounds = fillRounds(input);
		return rpsRounds.stream().map(RPSRound::getTotalScore).reduce(Integer::sum).get();
	}

	public int getResultTwo(List<String> input) {
		ArrayList<RPSRound> rpsRounds = fillRounds(input);
		rpsRounds.forEach(RPSRound::evaluateSelf);
		return rpsRounds.stream().map(RPSRound::getTotalScore).reduce(Integer::sum).get();
	}

	public ArrayList<RPSRound> fillRounds(List<String> input) {
		ArrayList<RPSRound> roundList = new ArrayList<>();
		input.forEach(line -> {
			String[] values = line.split(" ");
			roundList.add(new RPSRound(values[0], values[1]));
		});
		return roundList;
	}

	enum Shape {
		ROCK,
		PAPER,
		SCISSOR
	}

	static class RPSRound {

		private final Shape opponent;
		private Shape self;

		public RPSRound(String opponent, String self) {
			this.opponent = mapShape(opponent.toLowerCase());
			this.self = mapShape(self.toLowerCase());
		}

		private Shape mapShape(String value) {
			return switch (value) {
				case "a", "x" -> ROCK;
				case "b", "y" -> PAPER;
				case "c", "z" -> SCISSOR;
				default -> null;
			};
		}

		public int getTotalScore() {
			return getPersonalScore() + getOutcomeScore();
		}

		public int getPersonalScore() {
			return switch (self) {
				case ROCK -> 1;
				case PAPER -> 2;
				case SCISSOR -> 3;
			};
		}

		public int getOutcomeScore() {
			if (self.equals(opponent)) {
				return 3;
			}
			if ((self.equals(ROCK) && opponent.equals(PAPER)) || (self.equals(PAPER) && opponent.equals(SCISSOR))
					|| (self.equals(SCISSOR) && opponent.equals(ROCK))) {
				return 0;
			}
			return 6;
		}

		public void evaluateSelf() {
			switch (self) {
				case ROCK -> {
					switch (opponent) {
						case ROCK -> {
							self = SCISSOR;
							return;
						}
						case PAPER -> {
							return;
						}
						case SCISSOR -> {
							self = PAPER;
							return;
						}
					}
				}
				case PAPER -> {
					self = opponent;
					return;
				}
				case SCISSOR -> {
					switch (opponent) {
						case ROCK -> {
							self = PAPER;
							return;
						}
						case PAPER -> {
							return;
						}
						case SCISSOR -> {
							self = ROCK;
							return;
						}
					}
				}
			}
		}
	}
}
