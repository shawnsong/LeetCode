package leetcode;

import java.util.Stack;

/**
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *  determine if the input string is valid.
 *
 *  The brackets must close in the correct order, "()" and "()[]{}" are all
 *  valid but "(]" and "([)]" are not.
 */
public class Q020_ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (stack.pop() != getOpen(c)){
				return false;
			}
		}
		return stack.isEmpty();
	}

	char getOpen(char c) {
		if (c == ')') {
			return '(';
		} else if (c == '}') {
			return '{';
		} else if (c == ']') {
			return '[';
		} else {
			return ' ';
		}
	}
}
