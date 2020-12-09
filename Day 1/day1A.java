import java.util.*;
import java.io.*;


public class day1A {
	
	public static Scanner scan;
	static boolean[][] dp;
	
	public static void main(String[] args) {
		
		try {
			File file = new File(args[0]);
			scan = new Scanner(file);
		}
		catch(IOException e) {
			System.err.println("Cannot open file.");
			System.exit(1);
		}
		
		int N = 200;
		int[] A = new int [N];
		int sum = 2020;
		
		for(int i = 0; i < N; i++) {
			if(scan.hasNextInt()) {
				A[i] = scan.nextInt();
			}
		}
		
		/*for(int i = 0; i < A.length; i++) {
			System.out.println(A[i] + " ");	
		}*/
		
		
		printSubset(A, N, sum);
	}
	
	static void printSubset(int A[], int N, int sum) {
		if(N == 0 || sum < 0)
			return;
			
		dp = new boolean[N][sum + 1];
		for(int i = 0; i < N; i++) {
			dp[i][0] =  true;
		}
		
		if(A[0] <= sum)
			dp[0][A[0]] = true;
			
		for(int i = 1; i < N; i++){
			for(int j = 0; j < sum + 1; j++) {
				dp[i][j] = (A[i] <= j) ? (dp[i-1][j] || dp[i-1][j-A[i]]) : dp[i-1][j];
			}
		}
		
		if (dp[N-1][sum] == false) {
			System.out.println("No subsets");
			return;
		}
		
		ArrayList<Integer> p = new ArrayList<>();
		printSubsetRec(A, N-1, sum, p);
	}
	
	static void display(ArrayList<Integer> v) {
		System.out.println(v);
	}
	
	static void printSubsetRec(int A[], int i, int sum, ArrayList<Integer> p) {
		
		if(i == 0 && sum != 0 && dp[0][sum]) {
			p.add(A[i]);
			display(p);
			p.clear();
			return;
		}
		
		if(i == 0 && sum == 0) {
			display(p);
			p.clear();
			return;
		}
		
		if(dp[i-1][sum]) {
			ArrayList<Integer> b = new ArrayList<>();
			b.addAll(p);
			printSubsetRec(A, i-1,sum, b);
		}
		
		if(sum >= A[i] && dp[i-1][sum - A[i]]) {
			p.add(A[i]);
			printSubsetRec(A, i-1, sum - A[i], p);
		}
	}
}
