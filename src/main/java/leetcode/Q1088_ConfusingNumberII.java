package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees,
 * they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
 * (Note that the rotated number can be greater than the original number.)
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 */
public class Q1088_ConfusingNumberII {
    int count;
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    int solution2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int[] nums = {0, 1, 6, 8, 9};
        count = 0;
        for (int i = 1; i <String.valueOf(n).length(); i++) {
            dfs(nums, map, 0, n);
        }
        return count;
    }

    void dfs(int[] nums, Map<Integer, Integer> map, long prev, int n) {
        if (prev > n) {
            return;
        }
        if (isConfusing(prev, map)) {
            count++;
        }
        for (int digit : nums) {
            if (digit == 0 && prev == 0) {
                continue;
            }
            long cur = prev * 10 + digit;
            dfs(nums, map, cur, n);
        }
    }

    boolean isConfusing(long num, Map<Integer, Integer> map) {
        long tmp = 0;
        long n = num;
        while (n > 0) {
            int d = (int) (n % 10);
            try {
                tmp = tmp * 10 + map.get(d);
            } catch (Exception ex) {
                System.out.println(d);
            }
            n = n / 10;
        }
        return tmp != num;
    }

    public int confusingNumberII(int N) {
        count = 0;
        String num = String.valueOf(N);
        int total = findTotal(num);
        // total - strobogramatical is the answer
        for (int i = 1; i <= num.length(); i++) {
            dfs(num, new char[i], 0, i - 1);
        }
        return total - count;
    }

    void dfs(String higher, char[] arr, int left, int right) {
        if (left > right) {
            String num = new String(arr);
            if (num.length() == higher.length() && num.compareTo(higher) > 0) {
                return;
            }
            count++;
            return;
        }

        for (char[] pair : pairs) {
            char leftChar = pair[0];
            char rightChar = pair[1];
            arr[left] = leftChar;
            arr[right] = rightChar;
            if (arr.length > 0 && arr[0] == '0') {
                continue;
            }
            if (left == right && leftChar != rightChar) {
                continue;
            }
            dfs(higher, arr, left + 1, right - 1);
        }
    }

    /**
     * find total of possible numbers consisting of only 0 1 6 8 9. If num starts with '2', total is 10 because
     * 0  1  6  8  9,
     * 10 11 16 18 19
     */
    int findTotal(String num) {
        // need to have this check. e.g. 10, we have 0 1 6 8 9 as 5 numbers
        // because starts with 1, so we recurse substring, then it's 0. then we recurse again,
        // num become empty string, so we need to return 1 to the original res to make res 6
        if (num.length() == 0) {
            return 1;
        }
        char first = num.charAt(0);
        int res = 0;
        for (char[] pair : pairs) {
            if (pair[0] < first) {
                res += Math.pow(5, num.length() - 1);
            }
        }
        // if starts with one of the following numbers, there might be more numbers
        // e.g. num is 67, there are 60, 61 & 66 can be included in the total
        if (first == '0' || first == '1' || first == '6' || first == '9' || first == '8') {
            res += findTotal(num.substring(1));
        }
        return res;
    }
}
