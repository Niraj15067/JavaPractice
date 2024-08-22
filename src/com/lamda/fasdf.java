package com.lamda;

public class fasdf {

	public static void main(String[] args) {
		
		generate("123","");

	}

	private static void generate(String up, String p) {
		
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		generate(up.substring(1),p+up.charAt(0));
		generate(up.substring(1), p);
		
	}

}
