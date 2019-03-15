package leetcode;

import java.util.*;

public class Q291_WordPatternII {

    public boolean wordPattern(String pattern, String str) {
        return helper(pattern.toCharArray(), str, 0, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean helper(char[] pattern, String str, int startIdx, int patternIdx,
                           Map<Character, String> map, Set<String> seen) {
        if (startIdx == str.length() && patternIdx == pattern.length) {
            return true;
        }
        if (startIdx == str.length() || patternIdx == pattern.length) {
            return false;
        }

        char p = pattern[patternIdx];
        for (int i = startIdx; i < str.length(); i++) {
            String word = str.substring(startIdx, i + 1);
            if (!map.containsKey(p)) {
                if (isValid(p, word, map, seen)) {
                    map.put(p, word);
                    seen.add(word);
                    if (helper(pattern, str, i + 1, patternIdx+1, map, seen)) {
                        return true;
                    }
                    seen.remove(word);
                    map.remove(p);
                }
            } else {
                if (isValid(p, word, map, seen)) {
                    if (helper(pattern, str, i + 1, patternIdx+1, map, seen)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean isValid(char p, String word, Map<Character, String> map, Set<String> seen) {
        if (!map.containsKey(p)) {
            return !seen.contains(word);
        } else {
            return map.get(p).equals(word);
        }
    }
}
