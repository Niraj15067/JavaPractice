package com.lamda;

public class FlowerBed {

	public static void main(String[] args) {
		
		int[] arr = {1,0,1,0,1};
		int plant = plantFlowers(arr);
		System.out.println(plant);
	}
	public static int plantFlowers(int[] arr) {
		
		int count = 1;
		int plant = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				count++;
			}else {
				plant += (count-1)/2;
				count = 0;
			}
		}
		return plant+count/2;
	}
}
