package codesss;

public class PermutationsString {

	public static void main(String[] args) {
		String str = "abc";
		findPermutations(str,"");
	}
	
	public static void findPermutations(String up, String p) {
		
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		findPermutations(up.substring(1), p+up.charAt(0));
		findPermutations(up.substring(1),p);
	}
}
