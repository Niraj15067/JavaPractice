package Codes;

public class ButterFly1 {

	public static void main(String[] args) {
		int N = 5;
        int space = 2 * (N - 1);
        for (int i = 1; i <= 2 * N - 1; i++) {
            int star = i;
            if (i > N)
                star = 2 * N - i;
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
            if (i>=N)
                space += 2;
            else
                space -= 2;
        }
    }
}
