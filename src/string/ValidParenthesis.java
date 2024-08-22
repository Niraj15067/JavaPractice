package string;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		String str = "()[]{}";
		boolean ans = validate(str);
		System.out.println(ans);
	}

	private static boolean validate(String str) {
		if(str.isEmpty()) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if ((!stack.isEmpty()) && ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{')
					|| (ch == ']' && stack.peek() == '['))) {
				stack.pop();
			}else {
				return false;
			}
		}
		return stack.isEmpty()?true:false;
	}
}
