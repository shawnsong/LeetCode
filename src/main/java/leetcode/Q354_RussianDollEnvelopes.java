package leetcode;

import java.util.Arrays;

public class Q354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length < 2) {
            return 0;
        }

        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        int[] tails = new int[envelopes.length];

        int size = 0;

        for (int i = 0; i < envelopes.length; i++) {
            int left = 0, right = size - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (envelopes[i][1] < tails[mid]) {
                    right = mid - 1;
                } else if (envelopes[i][1] > tails[mid]) {
                    left = mid + 1;
                } else {
                    break;
                }
            }
            tails[left] = envelopes[i][1];
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
