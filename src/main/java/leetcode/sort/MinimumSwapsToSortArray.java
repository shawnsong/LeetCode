package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumSwapsToSortArray {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        NumberIndex[] numberIndices = new NumberIndex[n];
        for (int i = 0; i < n; i ++) {
            numberIndices[i] = new NumberIndex(nums[i], i);
        }
        Arrays.sort(numberIndices, (n1, n2) -> n1.num - n2.num);

        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || numberIndices[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int idx = i;
            while (!visited[idx]) {
                visited[idx] = true;
                cycleSize++;
                idx = numberIndices[idx].index;
            }
            if (cycleSize > 0) {
                res += cycleSize - 1;
            }
        }
        return res;
    }

    class NumberIndex {
        int num;
        int index;
        NumberIndex(int n, int i) {
            num = n;
            index = i;
        }
    }
}
