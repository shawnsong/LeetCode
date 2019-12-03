package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Q726_NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = count(formula);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    TreeMap<String, Integer> count (String expr) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                int start = i;
                i++;
                while (i < expr.length() && expr.charAt(i) >= 'a' && expr.charAt(i) <= 'z') {
                    i++;
                }
                String atom = expr.substring(start, i);
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + expr.charAt(i) - '0';
                    i++;
                }
                i--;
                num = num == 0 ? 1 : num;
                map.put(atom, map.getOrDefault(atom, 0) + num);
            } else if (c == '(') {
                int start = i + 1;
                int left = 0;
                while (i < expr.length()) {
                    if (expr.charAt(i) == '(') left++;
                    if (expr.charAt(i) == ')') left--;
                    if (left == 0) break;;
                    i++;
                }
                String substr = expr.substring(start, i);
                Map<String, Integer> subRes = count(substr);
                i++;
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + expr.charAt(i) - '0';
                    i++;
                }
                num = num == 0 ? 1 : num;
                for (Map.Entry<String, Integer> entry : subRes.entrySet()) {
                    String atom = entry.getKey();
                    int atomCount = entry.getValue();
                    atomCount = atomCount * num;
                    map.put(atom, map.getOrDefault(atom, 0) + atomCount);
                }
            }
        }
        return map;
    }
}
