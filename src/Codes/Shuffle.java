package Codes;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {

	int n[];

	public Shuffle(int[] nums) {
		n = nums;
	}

	public int[] reset() {
		return n;
	}

	public int[] shuffle() {
		int shuffled[] = n.clone();
		Random rand = new Random();
		
		for(int i=0;i<shuffled.length;i++) {
			int j = rand.nextInt(i+1);
			int temp = shuffled[i];
			shuffled[i] = shuffled[j];
			shuffled[j] = temp;
		}
		
		return shuffled;
	}

	public static void main(String[] args) {
		Shuffle obj = new Shuffle(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();
		System.out.println(Arrays.toString(param_1));
		System.out.println(Arrays.toString(param_2));
	}
}
