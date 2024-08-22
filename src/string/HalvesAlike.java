package string;

public class HalvesAlike {

	public static void main(String[] args) {
		boolean halvesAreAlike = halvesAreAlike("textBook");
		System.out.println(halvesAreAlike);
	}

	public static boolean halvesAreAlike(String s) {
		int mid = s.length() / 2;
		String a = s.substring(0, mid);
		String b = s.substring(mid, s.length());
		int ac = 0;
		int bc = 0;
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
					|| c == 'U')
				ac++;
		}
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
					|| c == 'U')
				bc++;
		}
		if (ac == bc) {
			return true;
		} else {
			return false;
		}

	}
}
