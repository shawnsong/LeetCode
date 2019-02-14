package leetcode;

import java.util.BitSet;

/*
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: 
 Starting with any positive integer, replace the number by the sum of the squares of 
 its digits, and repeat the process until the number equals 1 (where it will stay), or 
 it loops endlessly in a cycle which does not include 1. Those numbers for which 
 this process ends in 1 are happy numbers.

 Example: 19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
 */
public class Q202_HappyNumber {

	public boolean isHappy(int n) {
		n = Math.abs(n);
		
		BitSet set = new BitSet();
		
		int num = n;
		while (num != 1) {
			num = getSum(num);
			if (set.get(num))
				return false;
			set.set(num);
		}
		
		return true;
	}
	
	private int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n = n / 10;
		}
		
		return sum;
	}
}
