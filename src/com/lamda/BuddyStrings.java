package com.lamda;

public class BuddyStrings {

	public static void main(String[] args) {
		boolean ans = findIfBuddy("seem","mees");
		System.out.println(ans);
	}

	private static boolean findIfBuddy(String s, String goal) {
		int diffIdx[] = new int[2];
		int count = 0;
		if(s.length()!=goal.length()) {
			return false;
		}
		for(int i=0;i<s.length();i++) {
			if(count>=2) {
				return false;
			}else {
				if(s.charAt(i)!=goal.charAt(i)) {
					count++;
					diffIdx[count-1]=i;
				}
			}
		}
		return s.charAt(diffIdx[0])==goal.charAt(diffIdx[1]) && s.charAt(diffIdx[1])==goal.charAt(diffIdx[0]);
	}

}
