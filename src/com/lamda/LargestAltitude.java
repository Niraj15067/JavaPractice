package com.lamda;

public class LargestAltitude {

	public static void main(String[] args) {
		int[] arr= {-5,1,5,0,-7};
		int ans=find(arr);
		System.out.println(ans);
	}

	private static int find(int[] gain) {
		int currentAltitude = 0;
	    int maxAltitude = 0;
	    for (int i = 0; i < gain.length; i++) {
	        currentAltitude += gain[i];
	        if (currentAltitude > maxAltitude) {
	            maxAltitude = currentAltitude;
	        }
	    }
	    return maxAltitude;
	}

}
