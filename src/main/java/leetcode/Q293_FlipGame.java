package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 2) {
            return  res;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                if (s.charAt(i) == '+') {
                    res.add(s.substring(0, i) + "--" + s.substring(i+2));
                } else {
                    res.add(s.substring(0, i) + "++" + s.substring(i+2));
                }
            }
        }
        return res;
    }
}
