package Codes;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

	public static void main(String[] args) {
		
		List<String> letterCombinations = letterCombinations("989");
		System.out.println(letterCombinations);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		letterCombinations(ans,digits,"");
		return ans;
	}

	private static void letterCombinations(List<String> ans, String up, String p) {
		
		if(up.isEmpty()) {
			ans.add(p);
			return;
		}
		int digit = up.charAt(0)-'0';
		if(digit<7) {
			for(int i=(digit-2)*3;i<(digit-1)*3;i++) {
				char ch = (char)('a'+i);
				letterCombinations(ans, up.substring(1),p+ch);
			}
		}else {
			if(digit==8) {
				for(int i=(digit-2)*3+1;i<(digit-1)*3+1;i++) {
					char ch = (char)('a'+i);
					letterCombinations(ans, up.substring(1),p+ch);
				}
			}
			else if(digit==9) {
				for(int i=(digit-2)*3+1;i<=(digit-1)*3+1;i++) {
					char ch = (char)('a'+i);
					letterCombinations(ans, up.substring(1),p+ch);
				}
			}else {
				for(int i=(digit-2)*3;i<(digit-1)*3+1;i++) {
					char ch = (char)('a'+i);
					letterCombinations(ans, up.substring(1),p+ch);
				}
			}
		}
	}
}
