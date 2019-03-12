package leetcode;

import java.util.*;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 *
 * Hint:
 *
 * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
public class Q247_StrobogrammaticNumberII {


    List<String> findStrobogrammatic(int n) {
        List<String> res = find(n, n, "");
        return res;
    }

    List<String> find(int n, int m, String str) {
        if (n == 0) {
            return Arrays.asList("");
        }
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }

        List<String> sublist = find(n - 2, m, str);
        List<String> res = new LinkedList<>();
        for (String sub : sublist) {
            if (n != m) {
                res.add("0" + sub + "0");
            }
            res.add("1" + sub + "1");
            res.add("6" + sub + "9");
            res.add("8" + sub + "8");
            res.add("9" + sub + "6");
        }
        return res;
    }
}
