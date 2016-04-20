package leetcode;

/*
 Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 Hint:

 Consider the palindromes of odd vs even length. What difference do you notice?
 Count the frequency of each character.
 If each character occurs even number of times, then it must be a palindrome. 
 How about character which occurs odd number of times?
 */
public class Q266_PalindromePermutation {
	
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		
		int[] count = new int[26];
		
		int oddCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			count[c - 'a']++;
		}
		
		for (int i = 0; i < 26; i++)
			if (count[i] % 2 != 0)
				oddCount++;
		if (oddCount > 1)
			return false;
		else
			return true;
	}
}
