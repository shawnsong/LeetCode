package leetcode;

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Q125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s.length() <= 1)
			return true;

		int i = 0;
		int j = s.length() - 1;

		String str = s.toLowerCase();
		char start = str.charAt(i);
		char end = str.charAt(j);

		while (i < j) {
			while (!isAlphabet(start)) {
				i++;
				if (i >= j)
					return true;
				start = str.charAt(i);
			}

			while (!isAlphabet(end)) {
				j--;
				if (i >= j)
					return true;
				end = str.charAt(j);
			}

			if (start == end) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

	private boolean isAlphabet(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
			return true;
		return false;
	}
}
