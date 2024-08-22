package dynamicprogramming;

import java.util.Arrays;

public class FormTargetN {

	public static void main(String[] args) {
		int solve = solve(7);
		int[] dp = new int[8];
		Arrays.fill(dp, -1);
		int ans = solve1(7, dp);
		System.out.println(ans);
		System.out.println(solve);
	}

	public static int solve(int n) {
		if (n < 0) {
			return 0;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1; //Base case

		for (int i = 1; i <= n; i++) {
			dp[i] += i - 1 >= 0 ? dp[i - 1] : 0;
			dp[i] += i - 3 >= 0 ? dp[i - 3] : 0;
			dp[i] += i - 5 >= 0 ? dp[i - 5] : 0;
		}

		return dp[n];
	}
	
	static int solve1(int n, int[] dp) 
	{ 
	    // base case 
	    if (n < 0) 
	        return 0; 
	    if (n == 0) 
	        return 1; 
	  
	    // Checking if already calculated 
	    if (dp[n] != -1) 
	        return dp[n]; 
	  
	    // Storing the result and returning 
	    return dp[n] = solve1(n - 1,dp) + solve1(n - 3,dp) + solve1(n - 5,dp); 
	}

}
