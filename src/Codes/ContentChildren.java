package Codes;

import java.util.Arrays;

public class ContentChildren {

	public static void main(String[] args) {
		int[] g = {1,2};
		int[] s = {1,2,3};
		int content = findContentChildren(g, s);
		System.out.println(content);
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(s);
		Arrays.sort(g);
		
		int i=0,j=0,max=0;
		while(i<g.length && j<s.length) {
			if(g[i]<=s[j]) {
				max++;
				i++;
				j++;
			}else if(g[i]>s[j]) {
				j++;
			}
		}
		return max;
	}
}
