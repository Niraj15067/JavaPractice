package string;

public class StringSwap {

	public static void main(String[] args) {
		String s1 = "Niraj";
		String s2 = "Natsu";
		String temp = "";
//		temp = s1;
//		s1 = s2;
//		s2 = temp;
		int s1Size = 0;
		int s2Size = 0;
		
		while(s1Size<s1.length() && s2Size < s2.length()) {
			char a = s1.charAt(s1Size);
			char b = s1.charAt(s2Size);
			if(a==b) {
				s1Size++;
				s2Size++;
				continue;
			}
			a = (char) (a ^ b);
			b = (char) (a ^ b);
			a = (char) (a ^ b);
			s1.replace(s1.charAt(s1Size), a);
			s1.replace(s2.charAt(s2Size), b);
			s1Size++;
			s2Size++;
		}
		System.out.println(s1);
		System.out.println(s2);
	}
}
