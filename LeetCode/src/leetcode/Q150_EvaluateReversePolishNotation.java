package leetcode;

import java.util.ArrayDeque;

/*
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Q150_EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		ArrayDeque<String> stack = new ArrayDeque();

		for (int i = 0; i < tokens.length; i++) {
			if (!isOperator(tokens[i])) {
				stack.push(tokens[i]);
			} else {
				int n2 = Integer.parseInt(stack.pop());
				int n1 = Integer.parseInt(stack.pop());
				if (tokens[i].equals("+")) {
					stack.push(String.valueOf(n1 + n2));
				} else if (tokens[i].equals("-")) {
					stack.push(String.valueOf(n1 - n2));
				} else if (tokens[i].equals("*")) {
					stack.push(String.valueOf(n1 * n2));
				} else if (tokens[i].equals("/")) {
					stack.push(String.valueOf(n1 / n2));
				}
			}
		}

		return Integer.parseInt(stack.peek());
	}

	private boolean isOperator(String c) {
		return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
	}

}
