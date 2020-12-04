import java.util.*;
import java.io.*;

public class day2B {
	
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
		int passCount = 0;
		
		while(scan.hasNext()) {
			String num = scan.next();
			String[] parts = num.split("-");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			//int m = Integer.parseInt(String.valueOf(scan.next()));
			
			char c = scan.next().charAt(0);
			String strg = scan.nextLine();
			
			//System.out.println(n + " " + m + " " + c + " " + strg);
			
			//System.out.println(count);
			char firstIndex = strg.charAt(n);
			char lastIndex = strg.charAt(m);
			//System.out.println(firstIndex + " " + lastIndex);
			
			if(c == firstIndex && c != lastIndex || c != firstIndex && c == lastIndex) {
				passCount++;
			}
		}
		System.out.println(passCount);
		
	}
}