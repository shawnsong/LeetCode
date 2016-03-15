package leetcode;

public class Q313_SuperUglyNumber {

	public static void main(String[] args) {
		int n = 12;
		int[] primes = { 2, 3, 5, 7 };

		Q313_SuperUglyNumber obj = new Q313_SuperUglyNumber();

		int num = obj.nthSuperUglyNumber(12, primes);
		System.out.println(num);
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] primesPos = new int[primes.length];

		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = min(dp, primes, primesPos);
		}

		return dp[n - 1];
	}

	private int min(int[] dp, int[] primes, int[] primePos) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < primePos.length; i++) {
			int tmpRes = dp[primePos[i]] * primes[i];
			if (min > tmpRes) {
				min = tmpRes;
			}
		}
		for (int i = 0; i < primePos.length; i++) {
			if (min == dp[primePos[i]] * primes[i])
				primePos[i]++;
		}
		return min;
	}
}
