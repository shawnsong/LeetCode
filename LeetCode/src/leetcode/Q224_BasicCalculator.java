package leetcode;

import java.util.ArrayDeque;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:

"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

 */
public class Q224_BasicCalculator {
	
	public int calculate(String s) {
		ArrayDeque<Integer> stack = new ArrayDeque();
		
		int number = 0;
		int sum = 0;
		int prevSign = 1;
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
				number = Integer.parseInt(sb.toString());
				i--;
			} else if (c == '+') {
				sum += number * prevSign;
				prevSign = 1;
				number = 0;
			} else if (c == '-') {
				sum += number * prevSign;
				prevSign = -1;
				number = 0;
			} else if (c == '(') {
				stack.push(sum);
				stack.push(prevSign);
				prevSign = 1;
				sum = 0;
			} else {
				sum += number * prevSign;
				prevSign = stack.pop();
				
				int prevSum = stack.pop();
				sum = prevSum + sum * prevSign;
				prevSign = 1;
				number = 0;
			}
		}
		
		if (number != 0)
			sum += number * prevSign;
		
		return sum;
	}
	
}
