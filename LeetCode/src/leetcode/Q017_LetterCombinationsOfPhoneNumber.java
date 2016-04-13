package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 1: 
 2: abc
 3: def
 4: ghi
 5: jkl
 6: mno
 7: pqrs
 8: tuv
 9: wxyz
 
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Q017_LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> res = new LinkedList();
		if (digits == null || digits.length() == 0)
			return res;
		
		String[] table = {"", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		HashSet<String> set = new HashSet();
		combine(digits, "", set, table);
		res.addAll(set);
		return res;
	}
	
	private void combine(String digits,String comb, HashSet<String> cache, String[] table) {
		if (digits.length() == 0 && ! cache.contains(comb)) {
			cache.add(comb);
			return;
		}
		if (cache.contains(comb))
			return;

		int idx = digits.charAt(0) - '1';
		String chars = table[idx];
		for (char c : chars.toCharArray()) {
			combine(digits.substring(1), comb + c, cache, table);
		}
	}
	
}
