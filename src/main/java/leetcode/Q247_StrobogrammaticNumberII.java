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
        return find(n, n);
    }

    List<String> find(int m, int n) {
        if (m == 0) {
            return Arrays.asList("");
        }
        if (m == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> list = find(n - 2, n);
        List<String> res = new LinkedList<>();
        for (String num : list) {
            if (n != m) {
                res.add("0" + num + "0");
            }
            res.add("1" + num + "1");
            res.add("6" + num + "9");
            res.add("9" + num + "6");
            res.add("8" + num + "8");
        }
        return res;
    }
}
