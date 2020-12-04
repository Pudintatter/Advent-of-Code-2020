import java.util.*;
import java.io.*;

public class day3A {
	
	public static Scanner scan;
	
	public static void main(String[] args) {
		
		try {
			File file = new File(args[0]);
			scan = new Scanner(file);
		}
		catch(IOException e) {
			System.err.println("Cannot open file.");
			System.exit(1);
		}
		
		int treeCount = 0;
		int safeCount = 0;
		int lineCount = 1;
		
		int index = 0;
		
		while(scan.hasNext()){
			String line = scan.nextLine();
			System.out.println(line);
			String newLine = line;
			newLine = newLine.substring(0, index) + 'x' + newLine.substring(index + 1);
			System.out.println(newLine);
			System.out.println(index);
			if(line.charAt(index) == '#') {
				treeCount++;
				System.out.println("Tree");
			}
			else{
				safeCount++;
				System.out.println("safe");
			}
			
			index = (index + 3) % (line.length());
			
		}
		System.out.println(treeCount);
	}
}