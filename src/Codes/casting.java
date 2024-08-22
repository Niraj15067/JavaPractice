package Codes;

import java.util.Arrays;

public class casting {

	public static void main(String[] args) {
		double[] lots = getLots(0, 50);
		int fixedLots = (int) lots[0];
		double d = 0;
		if(d==0) {
			System.out.println("zero");
		}
		System.out.println(fixedLots);
		System.out.println(Arrays.toString(lots));
	}
	private static double[] getLots(double quantity,double unitSize) {
		double[] lots = new double[2];
	    double remainder = quantity%unitSize;
	    double fixed =(int) quantity/unitSize;
	    double terminal = 0;
	    
	    if(remainder>0) {
		    fixed-=1;
		    terminal=remainder+unitSize;
		}
	    lots[0]=fixed;
	    lots[1]=terminal;
	    return lots;
	}
}
