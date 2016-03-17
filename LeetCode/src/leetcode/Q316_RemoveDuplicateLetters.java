package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

/* 
Given a string which contains only lowercase letters, remove duplicate letters so that every 
letter appear once and only once. You must make sure your result is the smallest in 
lexicographical order among all possible results.

Example:

Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb" 

Note: we can only 'REMOVE' letters so the answer of second example is 'acdb' not 'abcd'
*/

public class Q316_RemoveDuplicateLetters {

	// using stack
	public String removeDuplicateLetter(String s) {
		int[] count = new int[26];
		boolean[] visited = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}

		ArrayDeque<Character> stack = new ArrayDeque();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (count[ch - 'a'] > 0)
				count[ch - 'a']--;
			if (visited[ch - 'a'])
				continue;
			while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
				char p = stack.pop();
				visited[p - 'a'] = false;
			}

			stack.push(ch);
			visited[ch - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}

	// greedy?
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0)
			return "";
		int[] lastPos = new int[26];
		Arrays.fill(lastPos, -1);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			lastPos[ch - 'a'] = i;
		}

		int minPos = s.length();
		for (int i = 0; i < lastPos.length; i++) {
			if (lastPos[i] >= 0)
				minPos = Math.min(minPos, lastPos[i]);
		}

		char minCh = 'z' + 1;
		int minChIdx = s.length();
		for (int i = 0; i <= minPos; i++) {
			char ch = s.charAt(i);
			if (minCh > ch) {
				minCh = ch;
				minChIdx = i;
			}
		}

		String remain = s.substring(minChIdx + 1).replaceAll(minCh + "", "");
		String removed = removeDuplicateLetters(remain);
		return minCh + removed;
	}
}
