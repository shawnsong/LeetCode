package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words 
 do not share common letters. You may assume that each word will contain only lower case letters. 
 If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 */
public class Q318_MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		int[] values = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			values[i] = convert(word);
		}

		int product = 0;
		for (int i = words.length - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if ((values[i] & values[j]) == 0)
					product = Math.max(words[i].length() * words[j].length(),
							product);
			}
		}
		return product;
	}

	private int convert(String word) {
		if (word == null || word.length() == 0)
			return 0;
		int num = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int idx = c - 'a';
			num = num | (1 << idx);
		}
		return num;
	}
}