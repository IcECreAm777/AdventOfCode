package day5;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Program started");
		
		String input = "";
		
		System.out.println("Part 1 of Day 5");
		int[] numbers = new int[input.length()];

		for(int index = 0; index < input.length(); index++) {
			numbers[index] = input.charAt(index) - '0';
		}

	}

}
