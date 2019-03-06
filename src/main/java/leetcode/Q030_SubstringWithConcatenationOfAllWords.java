package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q030_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        if (s == null || words.length == 0) {
            return res;
        }

        int numOfWords = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - wordLen * numOfWords + 1; i++) {
            Map<String, Integer> foundSoFar = new HashMap<>();
            int j = 0;
            for(; j < numOfWords; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (wordCount.containsKey(word)) {
                    foundSoFar.put(word, foundSoFar.getOrDefault(word, 0) + 1);
                    if (foundSoFar.get(word) > wordCount.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == numOfWords) {
                res.add(i);
            }
        }
        return res;
    }
}
