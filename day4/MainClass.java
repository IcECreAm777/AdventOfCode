package day4;

import java.util.Arrays;
import java.util.List;

import allDays.InputReader;

/**
 * 
 * @author Henning Gütschow
 * checks the passphrases for validity (Each line = 1 passphrase)
 * 
 * the program gets the words of an passphrase and ckecks if the word occurs twice or more.
 * 
 * Part 2 includes the rearrangement of the words (sorted alphabetically)
 */
public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Program started");

		InputReader ir = new InputReader();
		List<String> lines = ir.GetInput("./day4/Day4_Input");
		
		System.out.println("Part 1 of Day 4");
		
		int valid = 0;
		
		for(String line : lines) {
			boolean inv = false;
			String[] phrases = line.split(" ");
			
			for(int i = 0; i < phrases.length; i++) {
				for(int j = 0; j < phrases.length; j++) {
					if(i != j) {
						if(phrases[i].equals(phrases[j])) {
							inv = true;
						}
					}
				}
			}
			
			if(!inv) {
				valid++;
			}
		}
		
		System.out.println(valid);
		System.out.println("Part 2 of Day 4");
		
		valid = 0;
		
		for(String line : lines) {
			boolean inv = false;
			String[] phrases = line.split(" ");
			
			for(int i = 0; i < phrases.length; i++) {				
				for(int j = 0; j < phrases.length; j++) {
					if(i != j) {
						if(SortString(phrases[i]).equals(SortString(phrases[j]))) {
							inv = true;
						}
					}
				}
			}
			
			if(!inv) {
				valid++;
			}
		}
		
		System.out.println(valid);
		System.out.println("Program ended");
	}

	static String SortString(String s) {
		StringBuilder output = new StringBuilder(s.length());
		char[] c = new char[s.length()];
		
		for(int index = 0; index < s.length(); index++) {
			c[index] = s.charAt(index);
		}
		
		Arrays.sort(c);
		
		for(char ch : c) {
			output.append(ch);
		}
		
		return output.toString();
	}
}
