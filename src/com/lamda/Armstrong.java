package com.lamda;

public class Armstrong {

	public static void main(String[] args) {
		int num = 153;
		int ans = armstrong(num,0);
		if(ans==num)
			System.out.println(ans+" is a armstrong number");
		else
			System.out.println(ans+" it is not a armstrong number");
	}

	private static int armstrong(int num,int ans) {
		
		if(num==0) {
			return 0;
		}
		ans = (int)Math.pow(num%10, 3);
		return ans+armstrong(num/10,ans);
	}

}
