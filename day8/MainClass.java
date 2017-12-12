package day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allDays.InputReader;

/**
 * 
 * @author Henning Gütschow
 * Interpretes instructions from the input file
 * 
 * The program executes the instructions given in the file and prints the highest number after the executeion 
 * 
 * Part 2 prints the biggest number which ever existed during runtime
 *
 */
public class MainClass {
	
	static Map<String, Integer> vars = new HashMap<String, Integer>();
	static int highestNumber = 0;
	
	public static void main(String[] args) {
		
		System.out.println("Program start");

		InputReader ir = new InputReader();
		List<String> input = ir.GetInput("./day8/Day8_Input");
		
		System.out.println("Part 1 of Day 8");
		
		//interpret lines
		for(String line : input) {
			String[] commands = line.split(" ");
			
			if(!vars.containsKey(commands[0])) {
				vars.put(commands[0], 0);
			}
			
			if(!vars.containsKey(commands[4])) {
				vars.put(commands[4], 0);
			}
			
			
			if(commands[5].equals("<=") && vars.get(commands[4]) <= Integer.parseInt(commands[6])) {
				Calculate(commands[0], Integer.parseInt(commands[2]), commands[1]);
			} else if (commands[5].equals("<") && vars.get(commands[4]) < Integer.parseInt(commands[6])) {
				Calculate(commands[0], Integer.parseInt(commands[2]), commands[1]);
			} else if (commands[5].equals("==") && vars.get(commands[4]) == Integer.parseInt(commands[6])) {
				Calculate(commands[0], Integer.parseInt(commands[2]), commands[1]);
			} else if (commands[5].equals("!=") && vars.get(commands[4]) != Integer.parseInt(commands[6])) {
				Calculate(commands[0], Integer.parseInt(commands[2]), commands[1]);
			} else if (commands[5].equals(">") && vars.get(commands[4]) > Integer.parseInt(commands[6])) {
				Calculate(commands[0], Integer.parseInt(commands[2]), commands[1]);
			} else if (commands[5].equals(">=") && vars.get(commands[4]) >= Integer.parseInt(commands[6])) {
				Calculate(commands[0], Integer.parseInt(commands[2]), commands[1]);
			}
		}
		
		//get biggest number
		Map.Entry<String, Integer> max = null;
		
		for(Map.Entry<String, Integer> entry : vars.entrySet()) {
			if(max == null || entry.getValue() > max.getValue()) {
				max = entry;
			}
		}
		
		System.out.println(max.getKey() + ": " + max.getValue());
		
		System.out.println("Part 2 of Day 8");
		System.out.println(highestNumber);
		System.out.println("Program End");

	}

	static void Calculate(String key, int value, String operation) {
		int number = 0;
		
		if(operation.equals("dec")) {
			number = vars.get(key) - value;
			vars.replace(key, number);
		} else if (operation.contains("inc")) {
			number = vars.get(key) + value;
			vars.replace(key, number);
		}
		
		if(number > highestNumber) {
			highestNumber = number;
		}
	}
}
