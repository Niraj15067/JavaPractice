package Codes;

import java.util.Arrays;

public class FindTheDifference {

	public static void main(String[] args) {
		char theDifference = findTheDifference("abcd", "abcde");
		System.out.println(theDifference);
	}

	public static char findTheDifference(String s, String t) {
		
		int a[] = new int[26];
		int b[] = new int[26];
		
		for(int i=0;i<s.length();i++) {
			int idx = s.charAt(i)-'a';
			a[idx]++;
		}
		for(int i=0;i<t.length();i++) {
			int idx = t.charAt(i)-'a';
			b[idx]++;
		}
		for(int i=0;i<t.length();i++) {
			int idx = t.charAt(i)-'a';
			if(!(a[idx]==b[idx])) {
				return t.charAt(i);
			}
		}
		return ' ';
	}
}
