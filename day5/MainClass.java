package day5;

import java.util.List;

import allDays.InputReader;

/**
 * 
 * @author Henning Gütschow
 * Tries to escape an array with the commands in it
 * 
 * The program gets the steps from the current index an increases the current index by the given steps. The steps on this position are incremented during the process.
 * 
 * Part 2 decrements the steps when the steps are 3 or more or else increments them.
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Program started");
		
		InputReader ir = new InputReader();
		List<String> input = ir.GetInput("./day5/day5_Input");
		
		System.out.println("Part 1 of Day 5");
		int[] numbers = new int[input.size()];

		for(int index = 0; index < input.size(); index++) {
			numbers[index] = Integer.parseInt(input.get(index));
		}

		int index = 0;
		int steps = 0;
		while (index < numbers.length) {
			numbers[index]++;
			index += numbers[index] - 1;
			
			steps++;
		}
		
		System.out.println(steps);
		
		System.out.println("Part 2 of Day 5");
		
		/*reset Array*/
		numbers = new int[input.size()];
		for(int i = 0; i < input.size(); i++) {
			numbers[i] = Integer.parseInt(input.get(i));
		}
		
		index = 0;
		steps = 0;
		
		while(index < numbers.length) {
			if(numbers[index] >= 3) {
				numbers[index]--;
				index += numbers[index] + 1;
			} else {
				numbers[index]++;
				index += numbers[index] - 1;
			}
			steps++;
		}
		
		System.out.println(steps);
		System.out.println("Program End");
	}

}
