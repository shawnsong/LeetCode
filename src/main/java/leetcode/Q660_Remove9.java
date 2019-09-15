package leetcode;

public class Q660_Remove9 {
    public int newInteger(int n) {
        int res = 0;
        int base = 1;
        while (n > 0) {
            int digit = n % 9;
            res = res + base * digit;
            base = base * 10;
            n = n / 9;
        }
        return res;
    }
}
