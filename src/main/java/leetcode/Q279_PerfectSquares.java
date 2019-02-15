package leetcode;

/*
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) 
 which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
 */
public class Q279_PerfectSquares {
	public static void main(String[] args) {
		Q279_PerfectSquares o = new Q279_PerfectSquares();
		int n = o.numSquares(12);
		System.out.println(n);
	}
	public int numSquares(int n) {
		if (n <= 0)
			return -1;
		
		int[] dp = new int[n + 1];
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = numSquares(i, dp);
		}
		return dp[n];
	}
	
	private int numSquares(int n, int[] dp) {
		if (n < 0)
			return -1;
		if (dp[n] != 0)
			return dp[n];
		
		int idx = (int)Math.sqrt(n);
		dp[n] = dp[n - 1] + 1;
		for (int i = idx; i > 0; i--) {
			if (i * i == n) {
				dp[n] = 1;
				return dp[n];
			}
			
			dp[i * i] = numSquares(i * i, dp);
			dp[n - i * i] = numSquares(n - i * i, dp);
			dp[n] = Math.min(dp[n], dp[i * i] + dp[n - i * i]);
		}
		return dp[n];
	}

/*
    public int numSquares(int n) {
		int len = (int)Math.sqrt(n);
		int[] square = new int[len];
		for (int i = 0; i < len; i++)
			square[i] = (i+1) * (i+1);
		
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <=n; i++) {
			int min = dp[i-1] + 1;
			for (int j = len-1; j >=0; j--) {
				if (i - square[j] >= 0)
					min = Math.min(dp[i - square[j]] + 1, min);
			}
			dp[i] = min;
		}
		return dp[n];
	}
	*/

}
