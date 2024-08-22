package string;

public class ValidPalindrome {

	public static void main(String[] args) {

//		System.out.println(isPalindrome("1b1"));
		System.out.println(1-'a');

	}

	

	public static boolean isPalindrome(String s) {
		if (s.length() == 0) {
			return true;
		}

		String palindrome = s.toLowerCase();
		String fin = "";
		for (int i = 0; i < palindrome.length(); i++) {
			char ch = palindrome.charAt(i);
			if (Character.isAlphabetic(ch))
				fin += ch;
			if (Character.isDigit(ch))
				fin += ch;
		}
		int i = 0;
		int j = fin.length() - 1;
		while (i < j) {
			if (fin.charAt(i) != fin.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}
}
