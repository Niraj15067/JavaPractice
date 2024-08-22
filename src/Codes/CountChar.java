package Codes;

public class CountChar {

	public static void main(String[] args) {
		String a = "Balaji";
		int count = getCount(a);
		System.out.println(count);
	}

	private static int getCount(String a) {
		int index = -1;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='j') {
				index = i;
			}
		}
		return index;
	}
}
