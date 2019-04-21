package leetcode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class Q038_CountAndSay {
	public String countAndSay(int n) {
		String n1 = "1";
		String next = null;
		
		for (int i = 2; i <= n; i++) {
			next = generateNext(n1);
			n1 = next;
		}
		
		return n1;
	}

	String generateNext(String str) {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char c = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
				continue;
			}
			sb.append(count).append(c);
			count = 1;
			c = str.charAt(i);
		}
		sb.append(count).append(c);
		return sb.toString();
	}
}
