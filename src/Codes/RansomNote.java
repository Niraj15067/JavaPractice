package Codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RansomNote {

	public static void main(String[] args) {
		
		boolean ans = canConstruct("aa", "aab");
		System.out.println(ans);
		boolean canConstruct1 = canConstruct1("aac", "aabbcc");
		System.out.println(canConstruct1);
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

//		List<Character> ransom = new ArrayList<>();
		List<Character> mag = new ArrayList<>();
		for(int i=0;i<magazine.length();i++) {
			mag.add(magazine.charAt(i));
		}
	
		for(int i=0;i<ransomNote.length();i++) {
			if(mag.contains(ransomNote.charAt(i))) {
				int idx = mag.indexOf(ransomNote.charAt(i));
				mag.remove(idx);
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean canConstruct1(String ransomNote, String magazine) {
		
		List<Character> ransom = new ArrayList<>();
		List<Character> mag = new ArrayList<>();
		
		for(int i=0;i<ransomNote.length();i++) {
			ransom.add(ransomNote.charAt(i));
		}
		for(int i=0;i<magazine.length();i++) {
			mag.add(magazine.charAt(i));
		}
		
		Collections.sort(ransom);
		Collections.sort(mag);
		int len = Math.min(ransom.size(), mag.size());
		int rI = 0;
		int mI = 0;
		while(rI<len && mI<mag.size()) {
			if(ransom.get(rI)==mag.get(mI)) {
				rI++;
				mI++;
			}else {
				mI++;
			}
		}
		if(rI==ransom.size()) {
			return true;
		}else {
			return false;
		}
	}

}
