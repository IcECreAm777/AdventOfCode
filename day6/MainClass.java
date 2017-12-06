package day6;

import java.util.ArrayList;
import java.util.List;

import allDays.InputReader;

/**
 * 
 * @author Henning Gütschow
 * Allocate infinite loop errors and get the steps where a snapshot occurs twice 
 * 
 * The Program gets the biggest number in the array and increments the next blocks until the number is 0
 * 
 * Part 2 gets where the snapshot occurs a third time
 */
public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Program start");
		
		InputReader ir = new InputReader();
		String input = ir.GetInput("./day6/Day6_Input").get(0);
		String[] splittedInput = input.split("\t");
		
		int[] memory = new int[splittedInput.length];
		List<List<Integer>> snapshots = new ArrayList<List<Integer>>();
		
		List<Integer> currentSnapshot = new ArrayList<Integer>();
		
		int steps = 0;
		
		System.out.println("Part 1 of Day 6");
		
		for(int i = 0; i < splittedInput.length; i++) {
			memory[i] = Integer.parseInt(splittedInput[i]);
		}
		
		boolean found = false;

		while(!found) {
			int biggestNumber = 0;
			int index = 0;
			
			for(int i = 0; i < memory.length; i++) {
				if(memory[i] > biggestNumber) {
					biggestNumber = memory[i];
					index = i;
				}
			}
			
			memory[index] = 0;
			
			while(biggestNumber > 0) {
				index++;
				
				if(index >= memory.length) {
					index = 0;
				}
				
				memory[index]++;
				biggestNumber--;
			}
			
			currentSnapshot = new ArrayList<Integer>();
			for(int i = 0; i < memory.length; i++) {
				currentSnapshot.add(memory[i]);
			}
			
			found = snapshots.contains(currentSnapshot);
			snapshots.add(currentSnapshot);
			steps++;
		}
		
		System.out.println(steps);
		
		System.out.println("Part 2 of Day 6");
		
		/*
		 * Reset current values execpt the memory state and add the current memory state
		 * as Snapshot
		 */
		currentSnapshot = new ArrayList<Integer>();
		for(int i = 0; i < memory.length; i++) {
			currentSnapshot.add(memory[i]);
		}
		
		steps = 0;
		found = false;
		snapshots = new ArrayList<List<Integer>>();
		
		snapshots.add(currentSnapshot);
		
		while(!found) {
			int biggestNumber = 0;
			int index = 0;
			
			for(int i = 0; i < memory.length; i++) {
				if(memory[i] > biggestNumber) {
					biggestNumber = memory[i];
					index = i;
				}
			}
			
			memory[index] = 0;
			
			while(biggestNumber > 0) {
				index++;
				
				if(index >= memory.length) {
					index = 0;
				}
				
				memory[index]++;
				biggestNumber--;
			}
			
			currentSnapshot = new ArrayList<Integer>();
			for(int i = 0; i < memory.length; i++) {
				currentSnapshot.add(memory[i]);
			}
			
			found = snapshots.contains(currentSnapshot);
			snapshots.add(currentSnapshot);
			steps++;
		}
		
		System.out.println(steps);
		System.out.println("Program End");
	}

}
