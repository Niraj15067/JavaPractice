package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class tp {

	public static void main(String[] args) {
		
		String s = "  my name is Niraj Tiwari  ";
		String ans = reverse1(s);
		System.out.println(ans);
	}

	private static String reverse(String s) {
		String str = s.trim();
		String[] split = str.split(" ");
		String[] n = new String[split.length];
		List<String> sp= new ArrayList<>();
		sp.addAll(Arrays.asList(split));
		for(int i=0;i<sp.size();i++) {
			StringBuilder sb = new StringBuilder(sp.get(i));
			n[i] = sb.reverse().toString();
		}
		String ans = "";
		for(String e : n) {
			ans += e+" ";
		}
		return ans;
	}
	private static String reverse1(String s) {
		String a = s.trim();
		String[] split = a.split("\s");
		List<String> sp= new ArrayList<>();
		sp.addAll(Arrays.asList(split));
		List<String> l = new ArrayList<>();
		sp.stream().forEach(e->{
			StringBuilder sb = new StringBuilder(e);
			l.add(sb.reverse().toString());
		});
		String ans = "";
		Optional<String> reduce = l.stream().reduce((f,e)->f+" "+e);
		ans = reduce.get();
		return ans;
	}
}
