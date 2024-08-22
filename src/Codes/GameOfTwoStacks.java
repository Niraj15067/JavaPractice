package Codes;

import java.util.Arrays;
import java.util.Scanner;

public class GameOfTwoStacks {
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size for the first stack: ");
		int mSize = sc.nextInt();
		System.out.println("Enter the size for the first stack: ");
		int nSize = sc.nextInt();
		System.out.println("Enter the maxSum for the game: ");
		int maxSum = sc.nextInt();
		System.out.println("Enter "+mSize+" elements for the first stack: ");
		int[] m = new int[mSize];
		int[] n = new int[nSize];
		for(int i=0;i<mSize;i++) {
			int val = sc.nextInt();
			m[i] = val;
		}
		System.out.println("Enter "+nSize+" elements for the second stack: ");
		for(int i=0;i<nSize;i++) {
			int val = sc.nextInt();
			n[i] = val;
		}             
		int ans = play(m,n,maxSum,0);
		System.out.println("Score is : "+ans);
		sc.close();
	}

	private static int play(int[] m, int[] n, int maxSum, int score) {
		if(maxSum<0) {
			return score-1;
		}
		if(m.length==0 || n.length==0) {
			return score;
		}
		int leftChoose = play(Arrays.copyOfRange(m,1,m.length),n,maxSum-m[0],score+1);
		int rightChoose = play(m,Arrays.copyOfRange(n,1,n.length),maxSum-n[0],score+1);
		return Math.max(leftChoose, rightChoose);
	}
}
