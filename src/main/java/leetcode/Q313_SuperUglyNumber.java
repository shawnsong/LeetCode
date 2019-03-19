package leetcode;

public class Q313_SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n];
		int[] primePos = new int[primes.length];

		dp[0] = primes[0];
		for (int i = 1; i < n; i++) {
			dp[i] = findMin(dp, primes, primePos);
		}
		return dp[n-1];
	}

	private int findMin(int[] dp, int[] primes, int[] uglyPos) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < primes.length; i++) {
			int tmpRes = dp[uglyPos[i]] * primes[i];
			min = Math.min(min, tmpRes);
		}

		for (int i = 0; i < primes.length; i++) {
			if (dp[uglyPos[i]] * primes[i] == min) {
				uglyPos[i]++;
			}
		}
		return min;
	}

}
