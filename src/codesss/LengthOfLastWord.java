package codesss;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
//		int len = find(str);
		int ans = firstUniqChar(str);
		System.out.println(ans);
	}

	private static int find(String str) {
		StringBuilder sb = new StringBuilder(str);
		Map<String, Integer> m = new LinkedHashMap<>();
		return sb.indexOf("W");
	}

	public static int firstUniqChar(String s) {
		Map<Character, Integer> count = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (count.containsKey(s.charAt(i))) {
				count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
			} 
		}
		for(int i=0;i<s.length();i++) {
			if(count.get(s.charAt(i))==1) {
				return i;
			}
		}
		return -1;
	}

}
