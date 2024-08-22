package codesss;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String arr[] = {"dog","racecar","car"};
		String ans = longestCommonPrefix(arr);
		System.out.println(ans);
	}

	//1ms runtime less efficient than the below one.
	private static String longestCommonPrefix(String[] strs) {
		StringBuilder longest = new StringBuilder(strs[0]);
		for(int i=1;i<strs.length;i++) {
			longest = calculate(longest,strs[i]);
		}
		return longest.toString();
	}

	private static StringBuilder calculate(StringBuilder longest, String current) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<current.length() && i<longest.length();i++) {
			if(longest.charAt(i)==current.charAt(i)) {
				sb.append(longest.charAt(i));
			}else {
				break;
			}
		}
		return sb;
	}
	
	private static String longestCommonPrefix1(String[] strs) {
		
		StringBuilder prefix = new StringBuilder(strs[0]);
		for(String s : strs) {
			while(s.indexOf(prefix.toString())!=0) {
				prefix.setLength(prefix.length()-1);
				if(prefix.length()==0) {
					return "";
				}
			}
		}	
		return prefix.toString();
	}
}
