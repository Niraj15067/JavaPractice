package Arrays;

public class ConsecutiveSum {
	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 5, 7, 8, 6 };
		int sum = calculate(arr, 3);
		System.out.println(sum);
		//hello 
	}

	private static int calculate(int[] arr, int w) {
		int start = 0, end = 0;
		int sum = 0;
		int max = 0;
		while (end < arr.length) {
			sum += arr[end];
			if (end - start == w - 1) {
				max = Math.max(sum, max);
				sum -= arr[start++];
			}
			end++;
		}
		return max;
	}
}
