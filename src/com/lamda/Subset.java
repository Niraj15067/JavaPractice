package com.lamda;

public class Subset {

	public static void main(String[] args) {
		generate("","abcd");
	}

	private static void generate(String fixed, String remaining) {
		
		if(remaining.length()==1) {
			System.out.println(fixed+remaining);
			return; 
		}
		
		for(int i=0;i<remaining.length();i++) {
			String newFixed = fixed + remaining.charAt(i);
			String newRemaining = remaining.substring(0,i)+remaining.substring(i+1);
			generate(newFixed, newRemaining);
		}
	}

}
