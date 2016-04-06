package leetcode;

/*
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100". 
 */
public class Q067_AddBinary {
	public static String addBinary(String a, String b) {
		if (a == null || b == null)
			return a == null ? b : a;
		int len1 = a.length();
		int len2 = b.length();
		
		int i = len1 - 1;
		int j = len2 - 1;
		
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		
		while (i >= 0 && j >= 0) {
			int d = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
			if (d >= 2) {
				d = d % 2;
				carry = 1;
			} else {
				carry = 0;
			}
			i--;
			j--;
			sb.append(d);
		}
		
		while (i >= 0) {
			int d = a.charAt(i) - '0' + carry;
			if (d == 2) {
				d = 0;
				carry = 1;
			} else
				carry = 0;
			i--;
			sb.append(d);
		}
		
		while (j >= 0) {
			int d = b.charAt(j) - '0' + carry;
			if (d == 2) {
				d = 0;
				carry = 1;
			} else
				carry = 0;
			j--;
			sb.append(d);
		}
		if (carry == 1)
			sb.append(1);
		
		return sb.reverse().toString();
	}
}
