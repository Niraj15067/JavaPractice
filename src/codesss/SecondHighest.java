package codesss;

public class SecondHighest {

	public static void main(String[] args) {
		int[] arr = { 1,1,1,1,1,1};
		int ans = find(arr);
		System.out.println(ans);
	}

	private static int find(int[] arr) {

		int highest = arr[0], sHighest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > highest) {
				sHighest = highest;
				highest = arr[i];
			} else if (arr[i] > sHighest) {
				sHighest = arr[i];
			}
		}
		if(highest==sHighest) {
			return -1;
		}
		return sHighest;
	}
}
