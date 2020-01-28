package leetcode;

/*
 Given a non negative integer number num. For every numbers i in the range 0 <= i <= num calculate the number of 1's in
 their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:
 Space complexity should be O(n).
 Hint:

 You should make use of what you have produced already.
 Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 Or does the odd/even status of the number help you in calculating the number of 1s?
 */
public class Q338_CountingBits {

	public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 0; i <= num; i++) {
            dp[i] = (i % 2) + dp[i >> 1];
        }
        return dp;
	}
}
