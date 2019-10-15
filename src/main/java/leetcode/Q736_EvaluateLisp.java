package leetcode;

import java.util.*;

public class Q736_EvaluateLisp {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }
    private int eval(String exp, Map<String, Integer> parent) {
        if (exp.charAt(0) != '(') {
            // just a number or a symbol
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-')
                return Integer.parseInt(exp);
            return parent.get(exp);
        }
        // create a new scope, add add all the previous values to it
        Map<String, Integer> map = new HashMap<>();
        map.putAll(parent);
        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(a")) { // add
            return eval(tokens.get(0), map) + eval(tokens.get(1), map);
        } else if (exp.startsWith("(m")) { // mult
            return eval(tokens.get(0), map) * eval(tokens.get(1), map);
        } else { // let
            for (int i = 0; i < tokens.size() - 2; i += 2)
                map.put(tokens.get(i), eval(tokens.get(i + 1), map));
            return eval(tokens.get(tokens.size() - 1), map);
        }
    }
    List<String> parse(String expr) {
        List<String> res = new LinkedList<>();
        int start = 0;
        int left = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                while (i < expr.length()) {
                    if (expr.charAt(i) == '(') {
                        left++;
                    } else if (expr.charAt(i) == ')') {
                        left--;
                    }
                    if (left == 0) {
                        break;
                    }
                    i++;
                }
                res.add(expr.substring(start, i + 1));
                start = i + 1;
            } else if (c == ' ') {
                if (start != i) {
                    res.add(expr.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < expr.length()) {
            res.add(expr.substring(start));
            if (expr.substring(start).length() == 0) {
                System.out.println(expr);
            }
        }
        return res;
    }
}
