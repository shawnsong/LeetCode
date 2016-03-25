package leetcode;

/*
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */

public class Q029_DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		boolean isNegative = (dividend < 0 && divisor > 0 || dividend > 0
				&& divisor < 0) ? true : false;

		long dividendL = Math.abs((long) dividend);
		long divisorL = Math.abs((long) divisor);

		if (divisorL > dividendL)
			return 0;

		long multiply = 1;
		long sum = divisorL;
		while (dividendL >= sum) {
			sum = (long) sum << 1;
			multiply = (long) multiply << 1;
		}

		sum = sum >> 1;
		multiply = multiply >> 1;

		if (!isNegative && multiply > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else {
			int res = (int) multiply
					+ divide((int) dividendL - (int) sum, (int) divisorL);
			if (isNegative)
				return 0 - res;
			else
				return res;
		}
	}
}
