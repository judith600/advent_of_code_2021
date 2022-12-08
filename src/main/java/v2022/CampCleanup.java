package v2022;

import java.util.List;

import common.TwoParts;

public class CampCleanup implements TwoParts {

	@Override
	public int getPartOne(List<String> input) {
		List<SectionPair> sectionPairs = input.stream().map(SectionPair::new).toList();
		return (int) sectionPairs.stream().filter(SectionPair::isFullyContained).count();
	}

	@Override
	public int getPartTwo(List<String> input) {
		List<SectionPair> sectionPairs = input.stream().map(SectionPair::new).toList();
		return (int) sectionPairs.stream().filter(SectionPair::isPartialOverlap).count();
	}

	static class SectionPair {

		List<Section> sections;

		SectionPair(String line) {
			String[] split = line.split(",");
			this.sections = List.of(new Section(split[0]), new Section(split[1]));
		}

		public boolean isFullyContained() {
			Section left = sections.get(0);
			Section right = sections.get(1);
			return isContained(left, right) || isContained(right, left);
		}

		public boolean isPartialOverlap() {
			Section left = sections.get(0);
			Section right = sections.get(1);
			return isOverlap(left, right) || isOverlap(right, left);
		}

		private boolean isOverlap(Section one, Section two) {
			return one.start <= two.end && one.end >= two.start;
		}

		private boolean isContained(Section one, Section two) {
			return one.start >= two.start && one.end <= two.end;
		}
	}

	static class Section {

		private final int start;
		private final int end;

		Section(String section) {
			String[] split = section.split("-");
			this.start = Integer.parseInt(split[0]);
			this.end = Integer.parseInt(split[1]);
		}

		int getStart() {
			return start;
		}

		int getEnd() {
			return end;
		}
	}
}
