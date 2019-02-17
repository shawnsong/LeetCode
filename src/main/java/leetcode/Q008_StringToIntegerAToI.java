package leetcode;

public class Q008_StringToIntegerAToI {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        int i = 0;
        int sign = 1;
        long res = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                break;
            }

            if (c == '-') {
                sign = -1;
            } else {
                sign = 1;
            }
            i++;
        }

        while (i < str.length()) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            res = res * 10 + c - '0';
            if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
                return 0;
            }
            i++;
        }

        return (int)res * sign;
    }
}
