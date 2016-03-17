package leetcode;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

*/
public class Q227_BasicCalculatorII {

	public int calculate(String s) {

		int prevSign = 1;
		int sum = 0;
		int number1 = 0;
		int number2 = 0;
				
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') continue;
			
			if (c >= '0' && c <= '9') {
				StringBuilder sb = new StringBuilder();
				while (i < s.length() && s.charAt(i)>= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i));
					i++;
				}
				number1 = Integer.parseInt(sb.toString());
				i--;
			} else if (c == '+') {
				
				sum = sum + number1 * prevSign;
				prevSign = 1;
				number1 = 0;
			} else if (c == '-') {
				sum = sum + number1 * prevSign;
				prevSign = -1;
				number1 = 0;
			} else if (c == '*') {
				i++;
				StringBuilder sb = new StringBuilder();
				while(s.charAt(i) == ' ') {
					i++;
					continue;
				}
				while (i < s.length() && s.charAt(i)>= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i));
					i++;
				}
				i--;
				number2 = Integer.parseInt(sb.toString());
				number1 = number1 * number2;
				
			} else if (c == '/') {
				i++;
				StringBuilder sb = new StringBuilder();
				while(s.charAt(i) == ' ') {
					i++;
					continue;
				}
				while (i < s.length() && s.charAt(i)>= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i));
					i++;
				}
				i--;
				number2 = Integer.parseInt(sb.toString());
				number1 = number1 / number2;
			}
		}
		
		if (number1 > 0)
			sum += number1 * prevSign;
		return sum;
	}
}
