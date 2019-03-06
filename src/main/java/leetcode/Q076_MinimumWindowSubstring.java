package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        if (t.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        int left = 0;
        String res = "";
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (!map.containsKey(rightChar)) {
                continue;
            }
            map.put(rightChar, map.get(rightChar) - 1);
            if (map.get(rightChar) >= 0) {
                count++;
            }
            while (count == t.length()) {
                String tmp = s.substring(left, right + 1);
                if (res == "") {
                    res = tmp;
                } else if (tmp.length() < res.length()) {
                    res = tmp;
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
