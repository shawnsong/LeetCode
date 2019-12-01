package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1278_PalindromePartitioningIII {

    public int palindromePartition(String s, int k) {
        if (k >= s.length()) {
            return 0;
        }

        return dfs(s, 0, k, new HashMap<>());
    }

    int dfs(String s, int startIdx, int k, Map<String, Integer> cache) {
        if (startIdx >= s.length() - 1) {
            return 0;
        }
        if (k == 0) {
            return minChangeToPalindrome(s.substring(startIdx));
        }
        if (cache.containsKey(s.substring(startIdx) + "-" + k)) {
            return cache.get(s.substring(startIdx) + "-" + k);
        }
        int res = Integer.MAX_VALUE;
        for (int i = startIdx; i < s.length(); i++) {
            String curstr = s.substring(startIdx, i + 1);
            int cur = cache.getOrDefault(curstr, minChangeToPalindrome(curstr));
            if (cur > res) {
                continue;
            }
            res = Math.min(cur + dfs(s, i + 1, k - 1, cache), res);
        }
        cache.put(s.substring(startIdx) + "-" + k, res);
        return res;
    }

    int minChangeToPalindrome(String s) {
        int count = 0;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
}
