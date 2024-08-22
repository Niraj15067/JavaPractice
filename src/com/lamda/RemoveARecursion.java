package com.lamda;

public class RemoveARecursion {

	public static void main(String[] args) {
//		String ans = skip("bccad");
//		String removed = skipApple("i want a red apple or a black apple");
		String removed = skipApple2("abdfdfappleccc");
		System.out.println(removed);
	}

	private static String skipApple2(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		char ch = up.charAt(0);
		
		if(up.startsWith("apple")) {
			return skipApple2(up.substring(5));
		}else {
			return ch + skipApple2(up.substring(1));
		}
	}

	private static String skipApple(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		int firstSpaceIdx = up.indexOf(" ");
		
		if(firstSpaceIdx==-1) {
			return up.equalsIgnoreCase("apple")?"":" "+up;
		}
		
		String str = up.substring(0, firstSpaceIdx);
		
		
		if(str.equalsIgnoreCase("apple")) {
			return skipApple(up.substring(firstSpaceIdx+1));
		}else {
			return str + " " + skipApple(up.substring(firstSpaceIdx+1));
		}
	}

	private static String skip(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		char ch = up.charAt(0);
		
		if(ch=='a') {
			return skip(up.substring(1));
		}else {
			return ch + skip(up.substring(1));
		}
	}
	
	
}
