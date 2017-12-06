package day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import allDays.InputReader;

/**
 * 
 * @author Henning Gütschow
 * substracts the lowest from the biggest number for each line and sums the results up.
 * 
 * Part 2 gets if 2 numbers can be devided for each line and sums the divide results up.
 *
 */
public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Programm started");
		
		InputReader ir = new InputReader();
		int sum = 0;
		
		System.out.println("Part 1 of Day 2");
		
		if(ir.GetInput("./day2/Day2_Input") != null) {
			for(String s : ir.GetInput("./day2/Day2_Input")) {
				List<Integer> oneLine = splitLines(s);
				
				oneLine.sort(new Comparator<Integer>() {
					@Override
					public int compare(Integer i1, Integer i2) {
				        if (i1 > i2) {
				            return 1;
				        }
				        if (i1 < i2) {
				            return -1;
				        }
				        return 0;
				    }
				});
				
				sum += oneLine.get(oneLine.size() - 1) - oneLine.get(0);
			}
		}
		
		System.out.println(sum);
		
		System.out.println("Part 2 of Day 2");
		
		sum = 0;
		if(ir.GetInput("./day2/Day2_Input") != null) {
			for(String s : ir.GetInput("./day2/Day2_Input")) {
				List<Integer> oneLine = splitLines(s);
				
				for(int i = 0; i < oneLine.size(); i++) {
					for(int j = 0; j < oneLine.size(); j++) {
						if((oneLine.get(i) % oneLine.get(j)) == 0 && oneLine.get(i) != oneLine.get(j)) {
							sum += oneLine.get(i) / oneLine.get(j);
						}
					}
				}
			}
		}
		
		System.out.println(sum);
		System.out.println("Program End");
	}

	private static List<Integer> splitLines(String s) {
		List<Integer> output = new ArrayList<Integer>();
		
		String[] line = s.split("\t");
		
		for(String st : line) {
			output.add(Integer.parseInt(st));
		}
		
		return output;
	}
	
}
