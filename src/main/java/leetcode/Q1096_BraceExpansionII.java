package leetcode;

import java.util.*;

public class Q1096_BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        Stack<List<String>> stack = new Stack<>();

        char prevSign = ',';
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '{') {
                int start = i + 1;
                int left = 0;
                while (i < expression.length()) {
                    if (expression.charAt(i) == '{') left++;
                    if (expression.charAt(i) == '}') left--;
                    if (left == 0) {
                        break;
                    }
                    i++;
                }
                String substr = expression.substring(start, i );
                List<String> subRes = braceExpansionII(substr);

                if (prevSign == '*') {
                    List<String> merged = merge(stack.pop(), subRes);
                    stack.push(merged);
                } else {
                    stack.push(subRes);
                }
                prevSign = '*';
            } else if (Character.isLetter(c)) {
                if (prevSign == '*') {
                    stack.push(merge(stack.pop(), Arrays.asList(c + "")));
                } else {
                    stack.push(Arrays.asList(c + ""));
                }
                prevSign = '*';
            } else if (c == ',') {
                prevSign = ',';
            }
        }

        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            List<String> items = stack.pop();
            for (String str : items) {
                if (set.add(str)) {
                    res.add(str);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private List<String> merge(List<String> l1, List<String> l2) {
        List<String> res = new LinkedList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }
}
