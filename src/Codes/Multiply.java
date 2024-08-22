package Codes;

public class Multiply {

	public static void main(String[] args) {
		
		String a = "41";
		String b = "25";
		
		String multiply = multiply(a, b);
		System.out.println(multiply);
	}

	public static String multiply(String a, String b) {

		StringBuilder sb = new StringBuilder();
		int[] mul = new int[a.length()+b.length()];
		//iterate backward and multiply like we normally do on pen and paper.
		for(int i = b.length()-1;i>=0;i--) {
			for(int j=a.length()-1;j>=0;j--) {
				int idx = j+i+1;
				int val1 = a.charAt(j)-'0'; 
				int val2 = b.charAt(i)-'0';
				mul[idx] += val1*val2;
			}
		}
		//now we have values in the array but these values contains carry value which we have to remove and add to the next 
		//element.
		int carry = 0;
		for(int i=mul.length-1;i>=0;i--) {
			int val = mul[i]+carry;
			carry = val/10;
			mul[i] = val%10;
		}
		
		for(int n: mul) {
			sb.append(n);
		}
		while(sb.length()>0 && sb.charAt(0)=='0') {
			sb.deleteCharAt(0);
		}
		return sb.length()==0?"0":sb.toString();
	}
}
