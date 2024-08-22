package codesss;

public class FlowerBed {

	public static void main(String[] args) {
		int[] place = {1,0,1,0,0};
		boolean ans = placeFlowers(place,1);
		System.out.println(ans);
	}

	private static boolean placeFlowers(int[] place, int n) {
		int count = 1;
		int plant = 0;
		for(int i=0;i<place.length;i++) {
			if(place[i]==0) {
				count++;
			}else {
				plant += (count-1)/2;
			}
		}
		plant += count/2;
		return plant>=n;
	}
}
