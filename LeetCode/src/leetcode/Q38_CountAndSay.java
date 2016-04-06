package leetcode;

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
 */
public class Q38_CountAndSay {
	public String countAndSay(int n) {
		String n1 = "1";
		String next = null;
		
		for (int i = 2; i <= n; i++) {
			next = getNext(n1);
			n1 = next;
		}
		
		return n1;
	}
	
	private String getNext(String n) {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		
		char c = n.charAt(0);
		for (int i = 1; i < n.length(); i++) {
			if (c == n.charAt(i)) {
				count++;
			} else {
				sb.append(count).append(c);
				c = n.charAt(i);
				count = 1;
			}
		}
		sb.append(count).append(c);
		return sb.toString();
	}
}
