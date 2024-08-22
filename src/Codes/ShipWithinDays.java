package Codes;

public class ShipWithinDays {

	public static void main(String[] args) {
		int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int shipWithinDays = shipWithinDays(weights, 5);
		System.out.println(shipWithinDays);
	}

	public static int shipWithinDays(int[] weights, int days) {
		int max = weights[0];
		int total = max;
		for (int i = 1; i < weights.length; i++) {
			max = Math.max(max, weights[i]);
			total += weights[i];
		}
		int left = max;
		int right = total;
		while (left <= right) {// we need to return an ans regardless even if less days are required.
			int mid = left + (right - left) / 2;
			int d = getDays(mid, weights);// to increase days we need to dec the capacity that is mid and vice versa.
			if (d - days <= 0) {
				right = mid - 1;
			} else {
				left = mid + 1;  //more days than required need to inc the capacity .
			}
		}
		return left;
	}

	private static int getDays(int capacity, int[] weights) {
		int days = 1;
		int sum = 0;
		for (int j = 0; j < weights.length; j++) {
			if (sum + weights[j] <= capacity) {
				sum += weights[j];
			} else {
				days++;
				sum = weights[j];
			}
		}
		return days;
	}
}
