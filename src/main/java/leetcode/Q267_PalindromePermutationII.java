package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q267_PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        int[] map = new int[256];
        List<String> res = new LinkedList<>();

        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int oddCount = 0;
        int oddIdx = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1) {
                oddCount++;
                oddIdx = i;
            }
            if (oddCount > 1) {
                return res;
            }
        }

        String palindrome = "";
        if (oddCount == 1) {
            palindrome += (char)oddIdx;
            map[oddIdx]--;
        }

        generate(map, palindrome, s.length(), res);
        return res;
    }

    private void generate(int[] map, String palindrome, int len, List<String> res) {
        if (palindrome.length() == len) {
            res.add(palindrome);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                String newPalin = (char)i + palindrome + (char)i;
                map[i] -= 2;
                generate(map, newPalin, len, res);
                map[i] += 2;
            }
        }
    }
}