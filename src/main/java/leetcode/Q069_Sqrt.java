package leetcode;

/*
Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Q069_Sqrt {
	public int mySqrt(int x) {
		if (x <= 1) {
		    return x;
        }

        int low = 1, high = x;
		while (true) {
		    int mid = low + (high - low) / 2;
		    if (mid > x / mid) {
		        high = mid - 1;
            } else {
		        if (mid + 1 > x / (mid + 1)) {
		            return mid;
                } else {
		            low = mid + 1;
		        }
            }
        }
	}
}
