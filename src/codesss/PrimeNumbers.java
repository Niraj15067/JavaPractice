package codesss;

public class PrimeNumbers {

	public static void main(String[] args) {
		int n = 499979;
		int ans = countPrimes(n);
		System.out.println(ans);
	}

	public static int countPrimes(int n) {
		int count = 0;
		for(int i=2;i<n;i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		
		return count;
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n; i++) {
			if(i==n)
				return true;
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
