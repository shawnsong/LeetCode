package leetcode;

public class Q306_AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "101";
		
		Q306_AdditiveNumber obj = new Q306_AdditiveNumber();
		
		boolean res = obj.isAdditiveNumber(num);
		System.out.println(res);
	}

	public boolean isAdditiveNumber(String num) {
		if (num.length() < 3)
			return false;
		for (int i = 0; i < num.length() - 2; i++) {
			boolean res = processAdd(num, 0, i);
			if (res == true)
				return true;
		}
		return false;
	}
	
	public boolean processAdd(String num, int firstStartIdx, int firstEndIdx) {
		if (firstEndIdx >= num.length())
			return false;
		String num1 = num.substring(firstStartIdx, firstEndIdx+1);
		for (int i = firstEndIdx + 1; i < num.length() - 1; i++) {
			String num2 = num.substring(firstEndIdx + 1, i + 1);
			if (num2.length() > 1 && num2.charAt(0) == '0')
				return false;
			
			String res = add(num1, num2);
			String remain = num.substring(i + 1);
			if (remain.equals(res))
				return true;
			else if (remain.indexOf(res) != -1) { 
				boolean canAdd = processAdd(num, firstEndIdx + 1, i);
				if (canAdd == true)
					return true;
			}
		}
		
		return false;
	}
	
	public String add(String num1, String num2) {
		int carry = 0;
		
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >=0) {
			char c1 = num1.charAt(i);
			char c2 = num2.charAt(j);
			
			int val = (c1-'0') + (c2 - '0') + carry;
			if (val > 9) {
				carry = 1;
				val -= 10;
			}
			else 
				carry = 0;
			
			sb.append(val);
			i--;
			j--;
		}
		while (i >= 0) {
			char c = num1.charAt(i);
			int val = c - '0' + carry;
			if (val > 9)  {
				carry = 1;
				val -= 10;
			}
			else
				carry = 0;
			sb.append(val);
			i--;
		}
		while (j >= 0) {
			char c = num2.charAt(j);
			int val = c - '0' + carry;
			if (val > 9) {
				carry = 1;
				val -= 10;
			}
			else
				carry = 0;
			sb.append(val);
			j--;
		}
		
		if (carry == 1)
			sb.append(1);
		
		return sb.reverse().toString();
	}
}

/**
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers,
 * each subsequent number in the sequence must be the sum of the preceding two.
 *
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Example 1:
 *
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 *
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 *              1 + 99 = 100, 99 + 100 = 199
 * Follow up:
 * How would you handle overflow for very large input integers?
 */