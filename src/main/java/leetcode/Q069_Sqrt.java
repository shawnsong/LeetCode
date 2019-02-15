package leetcode;

/*
Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Q069_Sqrt {
	public static int mySqrt(int x) {
		if (x < 0)
			return -1;
		if (x <= 1)
			return x;

		int low = 1;
		int high = x;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			// handle overflow
			if (mid > 46340) {
				high = mid - 1;
			} else if (x == mid * mid)
				return mid;
			else if (mid * mid < x)
				low = mid + 1;
			else
				high = mid - 1;
		}

		return high;

	}
}
