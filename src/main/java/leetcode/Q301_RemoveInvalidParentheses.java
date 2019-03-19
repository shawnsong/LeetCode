package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q301_RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        remove(s, 0, 0, new char[] {'(', ')'}, res);
        return res;
    }

    private void remove(String s, int lastInvalid, int lastRemoved, char[] pars, List<String> res) {
        int left = 0;
        for (int i = lastInvalid; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pars[0]) {
                left++;
            } else if (c == pars[1]) {
                left--;
            }
            if (left >= 0) {
                continue;
            }
            // left is negative, 1 extra ')' is provided
            for (int j = lastRemoved; j <= i; j++) {
                if (s.charAt(j) == pars[1] && (j == lastRemoved || s.charAt(j-1) == pars[0])) {
                    String extraRemoved = s.substring(0, j) + s.substring(j + 1);
                    remove(extraRemoved, i, j, pars, res);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (pars[0] == '(') {
            remove(reversed, 0, 0, new char[] {')', '('}, res);
        }  else {
            res.add(reversed);
        }
    }
}
