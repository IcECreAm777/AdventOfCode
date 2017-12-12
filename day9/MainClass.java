package day9;

import java.util.regex.Pattern;

import allDays.InputReader;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Program start");
		
		InputReader ir = new InputReader();
		String input = ir.GetInput("./day9/Day9_Input").get(0);
		String test = "";
		
		System.out.println("Part 1 of Day 9");
		
		//replace garbage
		test = test.replaceAll("<", replacement);
		
		int countGroups = 0;
		
		countGroups = CalculateGroups(test);
		
		System.out.println(countGroups);

		
		System.out.println("Program End");
	}
	
	static int CalculateGroups (String s) {
		int output = 0;
		
				
		
		return output;
	}

}
