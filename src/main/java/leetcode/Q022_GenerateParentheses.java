package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Q022_GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new LinkedList();
		generate("", n, n, res);
		return res;
	}
	
	private void generate(String solution, int left, int right, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(solution);
			return;
		}

		if (left > 0) {
			generate(solution + "(", left-1, right, res);
		}
		if (right > left) {
			generate(solution + ")", left, right - 1, res);
		}
	}
}
