package leetcode;

public class Q772_BasicCalculator {
    public int calculate(String s) {
        int lowVal = 0;
        char lowSign = '+';

        int highVal = 1;
        char highSign = '*';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    int digit = s.charAt(i) - '0';
                    num = num * 10 + digit;
                    i++;
                }
                i--;
                highVal = highSign == '*' ? highVal * num : highVal / num;
            } else if (c == '(') {
                int count = 0;
                int j = i;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        count++;
                    } else if (s.charAt(i) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                String sub = s.substring(j+1, i);
                int subRes = calculate(sub);
                highVal = highSign == '*' ? highVal * subRes : highVal / subRes;
            } else if (c == '+' || c == '-') {
                lowVal = lowVal + (lowSign == '+' ? highVal : -highVal);
                lowSign = c;

                highVal = 1;
                highSign = '*';
            } else if (c == '*' || c == '/') {
                highSign = c;
            }
        }
        return lowVal + (lowSign == '+' ? highVal : -highVal);
    }
}
