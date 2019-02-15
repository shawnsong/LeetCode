package leetcode;

public class Q043_MultiplyStrings {
	public static void main(String[] ar) {
		String  res = multiply("91", "999");
		System.out.println(res);;
	}
	public static String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0 || num1.equals("0") || num2.equals("0"))
			return "0";
		int[] res = new int[num1.length() + num2.length()];
		
		// n1.length > n2.length
		String n1 = num1.length() >= num2.length() ? num1 : num2;
		String n2 = num1.length() < num2.length() ? num1 : num2;
		
		int size = res.length;
		int carry = 0;
		
		for (int i = 0; i < n2.length(); i++) {
			for (int j = 0; j < n1.length(); j++) {
				int nn1 = n1.charAt(n1.length() - 1 - j) - '0';
				int nn2 = n2.charAt(n2.length() - 1 - i) - '0';
				int tmp = nn1 * nn2 + carry;
				tmp += res[size - 1 - i - j];
				if (tmp > 9) {
					carry = tmp / 10;
					tmp = tmp % 10;
				} else
					carry = 0;
				res[size - 1 - i - j] = tmp;
			}
			if (carry > 0) {
				int sum = res[size - 1 - i - n1.length()] + carry;
				if (sum > 9) {
					carry = 1;
				} else
					carry = 0;
				res[size - 1 - i - n1.length()] += sum % 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (res[i] == 0) {
			i++;
		}
		
		
		if (res[i] == 10) {
			res[i - 1] = 1;
			res[i] = 0;
			i--;
		}
		while (i < res.length) {
			sb.append(res[i]);
			i++;
		}
		return sb.toString();
	}
}
