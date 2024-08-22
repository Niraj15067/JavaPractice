package Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GCD {

	public static void main(String[] args) {
//		int gcd = gcd(5, 2);
//		System.out.println(gcd);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>(Arrays.asList(1, 8)));
		ans.add(new ArrayList<>(Arrays.asList(1, 16)));
		ans.add(new ArrayList<>(Arrays.asList(16, 21)));
		ans.add(new ArrayList<>(Arrays.asList(8, 9)));
		ans.add(new ArrayList<>(Arrays.asList(9, 18)));
		ans.add(new ArrayList<>(Arrays.asList(8, 18)));
		ans.add(new ArrayList<>(Arrays.asList(16, 42)));
		
		Collections.sort(ans,(l1,l2)->l1.get(0)-l2.get(0));
		System.out.println(ans);
	}

	private static int gcd(int a, int b) {

		int find = Math.min(a, b);
		while (find > 0) {
			if (a % find == 0 && b % find == 0) {
				break;
			}
			find--;
		}
		return find;
	}
}
