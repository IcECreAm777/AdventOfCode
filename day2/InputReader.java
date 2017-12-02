package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
	
	public List<String> GetInput() {
		
		List<String> output = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Henning\\eclipse-workspace\\AdventOfCode2017\\day2\\Day2_Input"));
			String line;
			
			while((line = br.readLine()) != null) {				
				output.add(line);
			}
			
			br.close();
			
			System.out.println("File successfully loaded");
			return output;
		} catch (Exception e) {
			System.out.println("File couldn't be loaded");
			return null;
		}
	}
}
