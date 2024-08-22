package string;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

	public static void main(String[] args) {

		String str = "time to practice";
		String pattern = "toc";
		String ans = smallestWindow(str, pattern);
		System.out.println(ans);
	}

	public static String smallestWindow(String s, String p) {
		Map<Character, Integer> pm = new HashMap<>();
		Map<Character, Integer> sm = new HashMap<>();
		String ans = "";
		int start = 0, end = 0;
		int plen = p.length();
		int windowLen = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < plen; i++) {
			pm.put(p.charAt(i), pm.getOrDefault(p.charAt(i), 0) + 1);
		}
		plen = pm.size();
		int curLen = 0;
		while (end < s.length()) {
			char ch = s.charAt(end);
			sm.put(ch, sm.getOrDefault(ch, 0) + 1);
			if (pm.containsKey(ch) && sm.get(ch) == pm.get(ch)) {
				curLen++;
			}
			while (curLen == plen && start <= end) {
				windowLen = end-start+1;
				if (windowLen < minLen) {
					ans = s.substring(start, end + 1);
					minLen = windowLen;
				}	
				char i = s.charAt(start++);
				if (pm.containsKey(i)) {
					sm.put(i, sm.getOrDefault(i, 0) - 1);
					if (sm.get(i) < pm.get(i)) {
						curLen--;
					}
				}
			}
			end++;
		}
		if(minLen==Integer.MAX_VALUE) {
			return "-1";
		}
		return ans;
	}

}
