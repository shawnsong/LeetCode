package leetcode;

/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.
Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

 */
public class Q009_PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		
		int tmp = 0;
		int n = x;
		while (n > 0) {
			tmp = tmp * 10;
			tmp = tmp + n % 10;
			n = n / 10;
		}
		
		return tmp == x;
	}
}
