package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1234 {
    public int balancedString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('R', 1);
        map.put('W', 2);
        map.put('E', 3);
        int[] counts = new int[4];
        for (char c : s.toCharArray()) {
            counts[map.get(c)]++;
        }
        int avg = s.length() / 4;
        Map<Character, Integer> charMap = new HashMap<>();
        int count = 0;
        if (counts[0] > avg) {
            charMap.put('Q', counts[0] - avg);
            count += counts[0] - avg;
        }
        if (counts[1] > avg) {
            charMap.put('R', counts[1] - avg);
            count += counts[1] - avg;
        }
        if (counts[2] > avg) {
            charMap.put('W', counts[2] - avg);
            count += counts[2] - avg;
        }
        if (counts[3] > avg) {
            charMap.put('E', counts[3] - avg);
            count += counts[3] - avg;
        }
        int left = 0;
        int min = s.length();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charMap.containsKey(c)) continue;
            charMap.put(c, charMap.get(c) - 1);
            if (charMap.get(c) >= 0) {
                count--;
            }
            while (count == 0) {
                char leftChar = s.charAt(left);
                int len = i - left + 1;
                min = Math.min(min, len);
                if (charMap.containsKey(leftChar)) {
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                    if (charMap.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return min == s.length() ? 0 : min;
    }
}
