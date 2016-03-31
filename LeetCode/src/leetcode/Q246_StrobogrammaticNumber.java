package leetcode;

/*
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example,

 the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Q246_StrobogrammaticNumber {

	public boolean isStrobogrammatic(String num) {
		for (int i = 0; i <= num.length() / 2; i++) {
			char head = num.charAt(i);
			char tail = num.charAt(num.length() - i - 1);
			
			if (reverse(head) != tail) {
				return false;
			}
		}
		
		int mid = num.length() / 2;
		if (num.length() % 2 == 1 && num.charAt(mid) != '0' && num.charAt(mid) != '1' && num.charAt(mid) != '8')
			return false;
		
		return true;
	}
	
	private char reverse(char c) {
		switch (c) {
		case '6':
			return '9';
		case '9':
			return '6';
		case '0':
			return '0';
		case '1':
			return '1';
		case '8':
			return '8';
		default:
			return '-';
		}
	}
}
