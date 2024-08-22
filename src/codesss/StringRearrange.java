package codesss;

import java.util.Map.Entry;
import java.util.TreeMap;

public class StringRearrange {

	public static void main(String[] args) {
		String str = "abc";
		String ans = reArrange(str);
		System.out.println(ans);
	}
	
	public static String reArrange(String s) {
		TreeMap<Character, String> count = new TreeMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(count.containsKey(c)) {
				count.put(c, count.get(c)+c);
			}else {
				count.put(c, c+"");
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Entry<Character, String> entry: count.entrySet()) {
			sb.append(entry.getValue());
		}
		return sb.toString();
	}

}
