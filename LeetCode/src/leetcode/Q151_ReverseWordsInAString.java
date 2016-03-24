package leetcode;

/*
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
public class Q151_ReverseWordsInAString {
	public String reverseWords(String s) {

		String[] parts = s.split(" ");
		StringBuilder sb = new StringBuilder();

		String prefix = "";
		for (int i = parts.length - 1; i >= 0; i--) {
			if (parts[i].equals(""))
				continue;
			sb.append(prefix).append(parts[i]);
			prefix = " ";
		}

		return sb.toString();
	}
}
