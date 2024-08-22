package com.lamda;

public class Fibo {

	public static void main(String[] args) {
//		fibo(6);
		for(int i=0;i<6;i++) {
			int ans = fibo1(i);
			System.out.println(ans);
		}
//		System.out.println(ans);
	}

	private static int fibo1(int num) {
	
		if(num<=1) {
			return num;
		}
		
		return fibo1(num-1)+fibo1(num-2);
		
	}

	private static void fibo(int num) {
		int num1=0;
		int num2=1;
		System.out.println(num1);
		System.out.println(num2);
		for(int i=2;i<num;i++) {
			int num3 = num1 + num2;
			num1=num2;
			num2=num3;
			System.out.println(num3);
		}
		
	}
	
	

}
