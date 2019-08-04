package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * A de Bruijn sequence of order n on a size-k alphabet A is a cyclic sequence in which every possible length-n string
 * on A occurs exactly once as a substring. It has length k^n, which is also the number of distinct substrings of length
 * n on a size-k alphabet; de Bruijn sequences are therefore optimally short.
 *
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 */
public class Q753_CrackingTheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append('0');
        }
        String init = res.toString();
        Set<String> set = new HashSet<>();
        set.add(init);
        backtrack(n, k, res, set, (int)Math.pow(k, n));
        return res.toString();
    }

    boolean backtrack(int n, int k, StringBuilder res, Set<String> set, int size) {
        if (set.size() == size) {
            return true;
        }

        // get the substring from last n-1 pos of result
        String prev = res.substring(res.length() - n + 1);
        for (char c = '0'; c < '0' + k; c++) {
            String permute = prev + c;
            if (!set.contains(permute)) {
                set.add(permute);
                res.append(c);
                if (backtrack(n, k, res, set, size)) {
                    return true;
                }
                set.remove(permute);
                res.setLength(res.length() - 1);
            }
        }
        return false;
    }
}
