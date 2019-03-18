package leetcode;

import java.util.*;

public class Q301_RemoveInvalidParentheses {

//    public List<String> removeInvalidParentheses(String s) {
//        List<String> res = new LinkedList();
//        remove(s, 0, 0, new char[] {'(', ')'}, res);
//        return res;
//    }
//
//    private void remove(String s, int lastInvalid, int lastDeleted, char[] pars, List<String> res) {
//        int left = 0;
//        for (int i = lastInvalid; i < s.length(); i++) {
//            if (s.charAt(i) == pars[0]) {
//                left++;
//            } else if (s.charAt(i) == pars[1]) {
//                left--;
//            }
//            if (left >= 0) {
//                continue;
//            }
//
//            for (int j = lastDeleted; j <= i; j++) {
//                if (s.charAt(j) == pars[1] && (j == lastDeleted || s.charAt(j - 1) == pars[0])) {
//                    // remove j so s MIGHT become valid
//                    String str = s.substring(0, j) + s.substring(j+1);
//                    remove(str, i, j, pars, res);
//                }
//            }
//             return;
//        }
//
//        String reversed = new StringBuilder(s).reverse().toString();
//        if (pars[0] == '(') {
//            remove(reversed, 0, 0, new char[] {')', '('}, res);
//        } else {
//            res.add(reversed);
//        }
//    }

    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        remove(s, 0, new char[]{'(', ')'}, ans);
        return new LinkedList<>(ans);
    }


    private void remove(String s, int startIdx, char[] pars, Set<String> res) {
        int left = 0;
        for (int i = startIdx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pars[0]) left++;
            else if (c == pars[1]) left--;
            if (left >= 0) {
                continue;
            }

            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == pars[1] && (j == 0 || s.charAt(j - 1) == pars[0])) {
                    String str = s.substring(0, j) + s.substring(j + 1);
                    remove(str, i, pars, res);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pars[0] == '(')
            remove(reversed, 0, new char[]{')', '('}, res);
        else {
            res.add(reversed);
        }
    }
}