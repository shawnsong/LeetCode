package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

 */
public class Q131_PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List res = new LinkedList();
		partition(s, 0, res, new ArrayList());
		return res;
	}
	
	private void partition(String s, int startIdx, List<List<String>> res, ArrayList<String> comb) {
		if (startIdx == s.length()) {
			List<String> list = new LinkedList();
			list.addAll(comb);
			res.add(list);
			return;
		}
		
		for (int i = startIdx; i < s.length(); i++) {
			String sub = s.substring(startIdx, i + 1);
			if (isPalindrome(sub)) {
				comb.add(sub);
				partition(s, i + 1, res, comb);
				comb.remove(comb.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		if (s.length() <= 1)
			return true;
		
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
