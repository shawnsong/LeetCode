package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();

        long next = 0;
        for (int num : nums) {
            if (num < next) {
                continue;
            } else if (num == next) {
                next++;
            } else {
                res.add(getRange(next, num - 1));
                next = (long)num + 1;
            }
        }
        if (next <= upper) {
            res.add(getRange(next, upper));
        }
        return res;
    }

    private String getRange(long low, long high) {
        if (low == high) {
            return String.valueOf(low);
        }
        return low + "->" + high;
    }
}
