package com.lamda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d {

    public static void main(String[] args) {
        String input = "abc";
//        generatePermutations(input);
        String str = "abc";
        List<String> ans=new ArrayList<>();
  		  solve(str,ans,0,str.length()-1);
  		  System.out.println(ans);
    }

    public static void generatePermutations(String input) {
        generatePermutationsHelper("", input);
    }

    private static void generatePermutationsHelper(String fixedPart, String remainingPart) {
        // Base case: If the remaining part has only one character, print the permutation
        if (remainingPart.length() == 1) {
            System.out.println(fixedPart + remainingPart);
            return;
        }

        // Recursive step: Fix each character at the beginning and generate permutations for the rest
        for (int i = 0; i < remainingPart.length(); i++) {
            char fixedChar = remainingPart.charAt(i);
            String newFixedPart = fixedPart + fixedChar;
            String newRemainingPart = remainingPart.substring(0, i) + remainingPart.substring(i + 1);
            generatePermutationsHelper(newFixedPart, newRemainingPart);
        }
        
    }
    

	  
	 
		private static void solve(String s,List<String> ans, int idx, int N) {
		  if (idx == N) {
			  ans.add(s);
			  return;
		  }
		    
		   for (int i = idx; i <= N; i++) {
		      s = swap(s, idx, i);
		      solve(s,ans, idx + 1, N);
		      s = swap(s, idx, i);
		   }
		  
		}
		public static String swap(String a, int i, int j) {
			 char temp;
			 char[] charArray = a.toCharArray();
			 temp = charArray[i];
			 charArray[i] = charArray[j];
			 charArray[j] = temp;
			 return String.valueOf(charArray);
		}
	
}

