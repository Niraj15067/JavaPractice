package com.lamda;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
	static int s=0;
	public static void main(String[] args) {
		List<Integer> number = new ArrayList<>();
		number.add(10);
		number.add(20);
		number.add(30);
		number.forEach(n->System.out.println(n));
		number.forEach(n->{
			s=s+n;
		});
		System.out.println("Sum is: "+s);
		String str="madam";
		String s ="";
		for(int i=str.length()-1;i>=0;i--)
		{
			s+=str.charAt(i);
		}
		System.out.println(s);
		if(str.equals(s))
		{
			System.out.println("Pallindrome");
		}
		else
		{
			System.out.println("Not Pallindrome");
		}
		int left=0;
		int right=str.length()-1;
		boolean flag=true;
		while(left<right)
		{
			if(str.charAt(left)!=str.charAt(right))
			{
				flag=false;
				break;
			}
			left++;
			right--;
		}
	}

}
