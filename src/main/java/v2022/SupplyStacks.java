package v2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import common.TwoParts;

public class SupplyStacks implements TwoParts {

	@Override
	public int getPartOne(List<String> input) {
		return 0;
	}

	public int getPartOne(List<String> input, List<Stack<String>> stacks) {
		List<Command> commands = input.stream().map(Command::new).toList();
		printStacks(stacks);
		commands.forEach(command -> IntStream.range(0, command.number).forEach(notUsed -> {
			printCommand(command);
			Stack<String> fromStack = stacks.get(command.fromStack - 1);
			Stack<String> toStack = stacks.get(command.toStack - 1);
			toStack.push(fromStack.pop());
			printStacks(stacks);
		}));
		String collect = stacks.stream().map(Stack::peek).collect(Collectors.joining());
		System.out.println("result: " + collect);
		return 0;
	}

	public int getPartTwo(List<String> input, List<Stack<String>> stacks) {
		List<Command> commands = input.stream().map(Command::new).toList();
		printStacks(stacks);
		commands.forEach(command -> {
			printCommand(command);
			Stack<String> fromStack = stacks.get(command.fromStack - 1);
			Stack<String> toStack = stacks.get(command.toStack - 1);
			LinkedList<String> queue = new LinkedList<>();
			IntStream.range(0, command.number).forEach(unused -> {
				queue.add(fromStack.pop());
			});
			while (queue.size() != 0) {
				toStack.push(queue.pollLast());
			}
			printStacks(stacks);
		});
		String collect = stacks.stream().map(Stack::peek).collect(Collectors.joining());
		System.out.println("result: " + collect);
		return 0;
	}

	private void printCommand(Command command) {
		System.out.printf("command: move %s from %s to %s%n", command.number, command.fromStack, command.toStack);
	}

	public void printStacks(List<Stack<String>> stacks) {
		stacks.forEach(current -> System.out.println("# " + stacks.indexOf(current) + ": " + current));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public int getPartTwo(List<String> input) {
		return 0;
	}

	private Stack<String> createStack(List<String> initialState) {
		Stack<String> stack = new Stack<>();
		stack.addAll(initialState);
		return stack;
	}

	static class Command {

		int number;
		int fromStack;
		int toStack;

		Pattern pattern = Pattern.compile("(move )(?<number>\\d+)( from )(?<fromStack>\\d)( to )(?<toStack>\\d)");

		Command(String line) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.matches()) {
				number = Integer.parseInt(matcher.group("number"));
				fromStack = Integer.parseInt(matcher.group("fromStack"));
				toStack = Integer.parseInt(matcher.group("toStack"));
			}
		}
	}
}
