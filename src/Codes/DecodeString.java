package Codes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public class DecodeString {

	public static void main(String[] args) {
		String encoded = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		//zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
		String decoded = decodeString(encoded);
		Logger logger = Logger.getLogger(DecodeString.class.getName());
		logger.info("Decoded string is : "+decoded);
	}

	static List<String> list = new ArrayList<>();
	public static String decodeString(String e) {
		StringBuilder sb = new StringBuilder();
		Deque<String> decoder = new ArrayDeque<>();
		for (int i = 0; i < e.length(); i++) {
			if (e.charAt(i) != ']') {
				if(Character.isDigit(e.charAt(i))) {
					String num = "";
					num += e.charAt(i);
					while(Character.isDigit(e.charAt(i+1))){
						num += e.charAt(i+1);
						i++;
					}
					decoder.push(num);
				}else {
					decoder.push(e.charAt(i)+"");
				}
			} else {
				currentDecoded(decoder);
			}
		}
		String remaining = "";
		while(!decoder.isEmpty()) {
			remaining = decoder.pop()+remaining;
		}
		list.add(remaining);
		for(String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	private static void currentDecoded(Deque<String> decoder) {
//		StringBuilder sb = new StringBuilder();
		String result = "";
		String current = "";
		while(!decoder.isEmpty()) {
			String s = decoder.pop();
			if(s.equals("[")) {
				decoder.push(result);
			}else if(Character.isDigit(s.charAt(0))) {
//				sb.append(result);
				result = current+result;
				current = result;
				int len = Integer.parseInt(s);
				for (int i = 0; i < len-1; i++) {
//					result += result;
					result += current;
				}
				current = "";
			}else {
				current = s + current;
			}
		}
		if(!current.equals(""))
			result=current+result;
		list.add(result);
	}
}
