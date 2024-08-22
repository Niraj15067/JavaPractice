package codesss;

public class FirstOccurence {

	public static void main(String[] args) {

		String str = "mississippi";
		int i = find(str, "issip");
		System.out.println(i);
	}

	private static int find(String haystack, String needle) {

		for(int i=0;i<haystack.length()-needle.length()-1;i++) {
			if(needle.charAt(0)==haystack.charAt(i)) {
				boolean ans = checkSubString(haystack,i,needle);
				if(ans)
					return i;
			}
		}
		return -1;
	}

	private static boolean checkSubString(String haystack, int i, String needle) {
		for(int k=i,j=0;j<needle.length();j++,k++) {
			if(haystack.charAt(k)!=needle.charAt(j))
				return false;
		}
		return true;
	}

}
