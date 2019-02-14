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
	
	public static String reverse(String s) {
		int i = s.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && s.charAt(i) == ' ')
			i--;
		
		int end = i + 1;
		String prefix = "";
		while (i >= 0) {
			while (i >= 0 && s.charAt(i) != ' ')
				i--;
			sb.append(prefix).append(s.substring(i + 1, end));
			
			while (i >= 0 && s.charAt(i) == ' ')
				i--;
			end = i + 1;
			prefix = " ";
		}
		
		return sb.toString();
	}
}
