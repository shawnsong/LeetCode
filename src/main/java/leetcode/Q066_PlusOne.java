package leetcode;

public class Q066_PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        boolean addOne = true;
        int len = digits.length;

        for (int i = 0; i < len; i++) {
            if (digits[i] != 9) {
                addOne = false;
                break;
            }
        }
        if (addOne) {
            int[] ret = new int[len + 1];
            ret[0] = 1;
            return ret;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        return digits;
    }
}
