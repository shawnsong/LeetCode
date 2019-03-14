package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        helper(num, target, 0, "", 0, 0, res);
        return res;
    }

    private void helper(String num, int target, int startIdx, String solution, long eval, long prev, List<String> res) {
        if (startIdx == num.length()) {
            if (target == eval) {
                res.add(solution);
            }
            return;
        }

        for (int i = startIdx; i < num.length(); i++) {
            if (i > startIdx && num.charAt(startIdx) == '0') {
                break;
            }

            long cur = Long.parseLong(num.substring(startIdx, i+1));
            if (startIdx == 0) {
                helper(num, target, i+1, ""+cur, eval+ cur, cur, res);
            } else{
                helper(num, target, i+1, solution+"+"+cur, eval+cur, cur, res);

                helper(num, target, i+1, solution+"-"+cur, eval-cur, -cur, res);

                helper(num, target, i+1, solution+"*"+cur, eval-prev + prev*cur, prev*cur, res);
            }
        }

    }
}
