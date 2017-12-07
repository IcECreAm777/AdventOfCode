package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allDays.InputReader;

/**
 * 
 * @author Henning Gütschow
 * Sorts the DVDs/Programs from the input depending on which they are carrying
 * 
 * The program gets the name of the dvd in each line and checks if the dvd is holded by another
 */
public class MainClass {
	
	static Map<String, Integer> weights = new HashMap<String, Integer>();
	static Map<String, List<String>> dvdHolding = new HashMap<String, List<String>>();
	static List<String> unbalanced = new ArrayList<String>();

	public static void main(String[] args) {
		
		System.out.println("Program start");
		
		InputReader ir = new InputReader();
		List<String> input = ir.GetInput("./day7/Day7_Input");
		
		String root = "";
		
		for(String s : input) {
			if(s.contains("->")) {
				s = s.replaceAll("\\s+", "");
				
				String name = s.substring(0, s.indexOf("("));
				
				List<String> current = new ArrayList<String>();
				s = s.substring(s.indexOf(">") + 1, s.length());
				for(String dvd : s.split(",")) {
					current.add(dvd);
				}
				
				dvdHolding.put(name, current);
			}
		}
		
		System.out.println("Part 1 of Day 7");
		
		for(int i = 0; i < input.size(); i++) {
			String dvd = input.get(i).replaceAll("\\s+", "").substring(0, input.get(i).indexOf("(") - 1);
			boolean found = false;
			
			for(int j = 0; j < input.size(); j++) {
				if(i != j) {
					if(input.get(j).contains(dvd)) {
						found = true;
					}
				}
			}
			
			if(!found) {
				root = dvd;
				System.out.println(dvd);
			}
		}
		
		System.out.println("Part 2 of Day 7");
		for(String s : input) {
			String dvd = s.replaceAll("\\s+", "").substring(0, s.indexOf("(") - 1);
			s = s.substring(s.indexOf("(") + 1, s.length());
			s = s.substring(0, s.indexOf(")"));
			int weight = Integer.parseInt(s);
			weights.put(dvd, weight);
		}
		
		CalculateWeight(root);
		
		System.out.println("Program End");
	}

	
	static int CalculateWeight(String dvd) {
		int output = weights.get(dvd);
		
		if(dvdHolding.containsKey(dvd)) {
			int[] weight = new int[dvdHolding.get(dvd).size()];
			int index = 0;
			for(String s : dvdHolding.get(dvd)) {
				weight[index] = CalculateWeight(s);
				output += weight[index];
				index++;
			}

			Arrays.sort(weight);
			
			if(weight[weight.length - 1] > weight[weight.length - 2]) {
				unbalanced.add(dvd);
			}
		}
		
		return output;
	}
}
