package leetcode;

import java.util.Stack;

/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all 
 valid but "(]" and "([)]" are not.
 */
public class Q020_ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				char open = getOpen(c);
				if (stack.isEmpty() || stack.pop() != open)
					return false;
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
	
	private char getOpen(char c) {
		switch(c) {
		case ')':
			return '(';
		case ']':
			return '[';
		case '}':
			return '{';
		default:
			return ' ';
		}
	}
}
