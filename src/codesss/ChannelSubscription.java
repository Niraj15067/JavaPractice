package codesss;

import java.util.Scanner;

public class ChannelSubscription {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int cost = sc.nextInt();
			int ans = calculateCost(num, cost);
			System.out.println(ans);
		}
		sc.close();
	}

	public static int calculateCost(int num, int cost) {
		int subs=(int) Math.ceil(num/6.0);
		return subs*cost;
	}
	
	
}
