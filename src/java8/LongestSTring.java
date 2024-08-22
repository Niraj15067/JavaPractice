package java8;

public class LongestSTring {

	public static void main(String[] args) {
		String s = "My name is Apoorva Nampalliwar";
		String[] split = s.split(" ");
		int max = -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			String current = split[i];
			if (current.length() > max) {
				max = current.length();
				sb.setLength(0);
				sb.append(current);
			}
		}
		System.out.println(sb.toString());
	}
}
