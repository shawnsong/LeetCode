package leetcode;

public class Q772_BasicCalculator {
    public int calculate(String s) {
        int o1 = 1, l1 = 0;
        int o2 = 1, l2 = 1;
        s = s.trim();
        int i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            o1 = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                l2 = (o2 == 1 ? l2 * num : l2 / num);
            } else if (c == '(') {
                int left = 0;
                int start = i;
                while (i < s.length()) {
                    if (s.charAt(i) == '(') {
                        left++;
                    }
                    if (s.charAt(i) == ')') {
                        left--;
                    }
                    if (left == 0) {
                        break;
                    }
                    i++;
                }
                String substr = s.substring(start + 1, i);
                int subRes = calculate(substr);
                l2 = (o2 == 1 ? l2 * subRes : l2 / subRes);
            } else if (c == '+' || c == '-') {
                l1 = l1 + o1 * l2;
                l2 = 1;
                o2 = 1;
                o1 = c == '+' ? 1 : -1;
            } else if (c == '*' || c == '/') {
                o2 = c == '*' ? 1 : -1;
            }
        }
        l1 = l1 + o1 * l2;
        return l1;
    }
}
