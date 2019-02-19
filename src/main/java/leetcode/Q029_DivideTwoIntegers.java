package leetcode;

/*
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */

public class Q029_DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
	    if (divisor == 0) {
	        return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }

        int ans = 0;

        while (dividend >= divisor) {
            int divisorMultiples = divisor;
            int times = 1;
            while (dividend > (divisorMultiples << 1)) {
                if ((divisorMultiples << 1)> 0) {
                    times = times << 1;
                    divisorMultiples = divisorMultiples << 1;
                } else {
                    // overflow
                    break;
                }
            }
            ans += times;
            dividend -= divisorMultiples;
        }
        return ans;
    }
}
