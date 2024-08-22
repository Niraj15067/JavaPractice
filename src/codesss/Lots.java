package codesss;

import java.util.Arrays;

public class Lots {
	public static void main(String[] args) {
		double[] incoming = getUnits(286.0000);
		double[] opposite = getUnits(236.0000);
		double tradeVal = Math.min(incoming[0], opposite[0])*50;
		System.out.println(Arrays.toString(incoming));
		System.out.println(Arrays.toString(opposite));
		if (Double.compare(incoming[1], opposite[1]) == 0)
			tradeVal+=incoming[1];
		System.out.println("Final trade value is: "+tradeVal);
	}

	public static double[] getUnits(double n) {
		double[] temp = new double[2];
		double remainder = n % 50;
		double fixed = (int) n / 50;
		double terminal = 0;

		if (remainder > 0) {
			fixed -= 1;
			terminal = remainder + 50;
		}
		temp[0] = fixed;
		temp[1] = terminal;
		return temp;
	}
}