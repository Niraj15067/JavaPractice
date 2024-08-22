package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 7;
		find(n);
		HashMap<Character, Integer> ans = new HashMap<>();
		ans.clear();
	}
	private static void find(int n) {
		int f[] = new int[n]; //for dp to store the answer at each n level so as to use it later on without cal it again.
		f[0] = 0;
		f[1] = 1;
		Arrays.fill(f, 2, f.length, -1);
		for(int i=0;i<n;i++) {
			int curFibo = fibo(i,f);
			System.out.println(curFibo);
		}
	}
	private static int fibo(int n, int[] f) {
		
		if(f[n]!=-1) {
			return f[n];
		}
		
		return f[n] = fibo(n-1,f) + fibo(n-2,f);
	}
}
