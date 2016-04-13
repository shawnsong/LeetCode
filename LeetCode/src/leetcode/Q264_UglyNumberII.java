package leetcode;

/*
 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number. 
 
 Hint:

    The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
    An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
    The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
    Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

 */
public class Q264_UglyNumberII {
	public int nthUglyNumber(int n) {
		int idx2 = 0;
		int idx3 = 0; 
		int idx5 = 0; 
		
		int[] dp = new int[n];
		dp[0] = 1;
		
		/*
		 * num2 * 2, num2 * 3, num2 * 5
		 * num3 * 3, num3 * 5
		 * num5 * 5
		 */
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(dp[idx2] * 2, Math.min(dp[idx3] * 3, dp[idx5] *5));
			if (dp[i] == dp[idx2] * 2)
				idx2++;
			if (dp[i] == dp[idx3] * 3)
				idx3++;
			if (dp[i] == dp[idx5] * 5)
				idx5++;
		}
		
		return dp[n - 1];
	}
}
