package leetcode;

import java.util.Stack;

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
			if (c == ' ')
				continue;

			if (c >= '0' && c <= '9') {
				StringBuilder sb = new StringBuilder();
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
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
				while (s.charAt(i) == ' ') {
					i++;
					continue;
				}
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					sb.append(s.charAt(i));
					i++;
				}
				i--;
				number2 = Integer.parseInt(sb.toString());
				number1 = number1 * number2;

			} else if (c == '/') {
				i++;
				StringBuilder sb = new StringBuilder();
				while (s.charAt(i) == ' ') {
					i++;
					continue;
				}
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
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

	public static int calculateUsingStack(String s) {
		int sum = 0;
		Stack<Integer> stack = new Stack();
		int num = 0;
		char op = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
				if (op == '+')
					stack.push(num);
				else if (op == '-') 
					stack.push(-num);
				else if (op == '*')
					stack.push(stack.pop() * num);
				else
					stack.push(stack.pop() / num);
				op = s.charAt(i);
				num = 0;
			}
			
		}

		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
