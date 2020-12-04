import java.util.*;
import java.io.*;

public class day3B {
	
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
		
		int[] treeCount = {0,0,0,0,0};
		int[] safeCount = {0,0,0,0,0};
		int[] index = {0,0,0,0,0};
		int[] slope ={1,3,5,7};
		int lineCount = 0;
		
		while(scan.hasNext()){
			String line = scan.nextLine();
			System.out.println("====================================");
			String newLine = line;
			for(int i = 0; i < slope.length; i++){
				newLine = newLine.substring(0, index[i]) + 'x' + newLine.substring(index[i] + 1);
				if(line.charAt(index[i]) == '#') {
					treeCount[i]++;
				}
				else{
					safeCount[i]++;
				}
				index[i] = (index[i] + slope[i]) % (line.length());
			}
			if ((lineCount % 2) == 0) {
				System.out.println(index[4]);
				if (line.charAt(index[4]) == '#') {
					treeCount[4]++;
				}
				else{
					safeCount[4]++;
				}
				index[4] = (index[4] + 1) % (line.length());
				System.out.println(index[4]);
			}
			lineCount++;
		}
		long total = 1;
		for(int i = 0; i < treeCount.length; i++){
			System.out.println(treeCount[i]);
			total = total * treeCount[i];
		}
		System.out.print("total trees hit: ");
		System.out.println(total);
	}
}