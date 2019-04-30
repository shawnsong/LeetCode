package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words
 *  do not share common letters. You may assume that each word will contain only lower case letters.
 *  If no such two words exist, return 0.
 *
 *  Example 1:
 *  Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 *  Return 16
 *  The two words can be "abcw", "xtfn".
 *
 *  Example 2:
 *  Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 *  Return 4
 *  The two words can be "ab", "cd".
 *
 *  Example 3:
 *  Given ["a", "aa", "aaa", "aaaa"]
 *  Return 0
 *  No such pair of words.
 */
public class Q318_MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		int[] vals = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			char[] word = words[i].toCharArray();
			for (char c : word) {
				int pos = c - 'a';
				vals[i] = vals[i] | 1 << pos;
			}
		}
		int max = 0;
		for (int i = 0; i < vals.length; i++) {
			for (int j = i + 1; j < vals.length; j++) {
				if ((vals[i] & vals[j]) == 0) {
					max = Math.max(words[i].length() * words[j].length(), max);
				}
			}
		}
		return max;
	}
}