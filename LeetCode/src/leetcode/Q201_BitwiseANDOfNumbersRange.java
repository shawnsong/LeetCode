package leetcode;

/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4. 
 */
public class Q201_BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		int diff = 0;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			diff++;
		}
		return 1 << diff;
	}
}
