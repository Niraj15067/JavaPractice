package com.lamda;

import java.util.*;

public class a {
	public static void main(String[] args) {
		boolean ans = isAnagram("anagram", "nagaram");
		System.out.println(ans);
	}

	public static boolean isAnagram(String s, String t) {
		char[] a =s.toCharArray();
		Arrays.sort(a);
		char[] b = t.toCharArray();
		Arrays.sort(b);
		if(s.length()!=t.length())
			return false;
		for(int i=0;i<s.length();i++) {
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
}