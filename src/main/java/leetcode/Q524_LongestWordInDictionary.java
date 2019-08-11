package leetcode;

import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some
 * characters of the given string. If there are more than one possible results, return the longest word with the
 * smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 */
public class Q524_LongestWordInDictionary {

    public String findLongestWord(String str, List<String> dict) {
        String res = null;

        for (String word : dict) {
            if (isSubsequence(str, word)) {
                if (res == null || word.length() > res.length()) {
                    res = word;
                }
                if (res.length() == word.length() && res.compareTo(word) > 0) {
                    res = word;
                }
            }
        }
        return res == null ? "" : res;
    }

    boolean isSubsequence(String str, String word) {
        if (str.length() < word.length()) return false;

        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == word.charAt(pos)) {
                pos++;
            }
            if (pos == word.length()) {
                return true;
            }
        }
        return pos == word.length();
    }
}
