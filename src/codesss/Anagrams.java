package codesss;

public class Anagrams {

	public static void main(String[] args) {
		String s = "python";
		String d = "typhon";
		boolean ans = anagram(s,d);
		boolean a = anagram1(s, d);
		System.out.println(a);
		System.out.println(ans);
	}
	public static boolean anagram1(String s, String d) {
		if(s.length()!=d.length()) {
			return false;
		}
		if(sort(s).equals(sort(d))) {
			return true;
		}else {
			return false;
		}
	}
	//without using sort.
	private static boolean anagram(String s, String d) {
		int[] a2z = new int[26];
		if(s.length()!=d.length()) {
			return false;
		}
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i)-97;
			a2z[index] += 1;
		}
		for(int i =0;i<d.length();i++) {
			int index = s.charAt(i)-97;
			a2z[index] -= 1;
		}
		for(int i=0;i<26;i++) {
			if(a2z[i]!=0) {
				return false;
			}
		}
		return true;
	}
	public static String sort(String s) {
		char[] arr = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<s.length()-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					char temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return String.valueOf(arr);
	}
}
