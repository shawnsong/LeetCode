package leetcode;

public class Q007_ReverseInteger {

    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        }

        long res = 0;

        while (x != 0) {
            res = (res * 10) + x % 10;
            x = x / 10;
        }

        res *= sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)res;
    }
}
