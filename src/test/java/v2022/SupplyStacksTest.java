package v2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import common.ReadInputUtil;

class SupplyStacksTest {

	private ArrayList<Stack<String>> realStacks;
	private ArrayList<Stack<String>> testStacks;
	private List<String> testInput;

	private SupplyStacks supplyStacks;

	@BeforeEach
	void setUp() {
		supplyStacks = new SupplyStacks();

		testInput = List.of("move 1 from 2 to 1", "move 3 from 1 to 3", "move 2 from 2 to 1", "move 1 from 1 to 2");
		testStacks = new ArrayList<>();
		testStacks.add(createStack(List.of("Z", "N")));
		testStacks.add(createStack(List.of("M", "C", "D")));
		testStacks.add(createStack(List.of("P")));

		realStacks = new ArrayList<>();
		realStacks.add(createStack(List.of("Q", "M", "G", "C", "L")));
		realStacks.add(createStack(List.of("R", "D", "L", "C", "T", "F", "H", "G")));
		realStacks.add(createStack(List.of("V", "J", "F", "N", "M", "T", "W", "R")));
		realStacks.add(createStack(List.of("J", "F", "D", "V", "Q", "P")));
		realStacks.add(createStack(List.of("N", "F", "M", "S", "L", "B", "T")));
		realStacks.add(createStack(List.of("R", "N", "V", "H", "C", "D", "P")));
		realStacks.add(createStack(List.of("H", "C", "T")));
		realStacks.add(createStack(List.of("G", "S", "J", "V", "Z", "N", "H", "P")));
		realStacks.add(createStack(List.of("Z", "F", "H", "G")));
	}

	@Test
	void getPartOne() {
//		supplyStacks.getPartOne(testInput, testStacks);
		supplyStacks.getPartOne(Objects.requireNonNull(ReadInputUtil.readLines("supplyStacks")), realStacks);
	}

	@Test
	void testCommandCreation() {
		SupplyStacks.Command command = new SupplyStacks.Command("move 15 from 2 to 8");
		assertEquals(15, command.number);
		assertEquals(2, command.fromStack);
		assertEquals(8, command.toStack);

		List<SupplyStacks.Command> commands = testInput.stream().map(SupplyStacks.Command::new).toList();
		commands.get(1);
	}

	@Test
	public void testStackBehaviour() {
		Stack<String> stack = new Stack<>();
		stack.addAll(List.of("Q", "M", "G", "C", "L"));
		String peek = stack.peek(); // L
		stack.pop();
	}

	@Test
	void getPartTwo() {
//		supplyStacks.getPartTwo(testInput, testStacks);

		supplyStacks.getPartTwo(ReadInputUtil.readLines("supplyStacks"), realStacks);
	}

	private Stack<String> createStack(List<String> initialState) {
		Stack<String> stack = new Stack<>();
		stack.addAll(initialState);
		return stack;
	}
}
