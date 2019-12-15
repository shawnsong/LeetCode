package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q300_1GetLIS {
    public List<List<Integer>> getLIS(int[] nums) {
        List<List<Integer>> increasing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            increasing.add(new ArrayList<>());
            increasing.get(increasing.size() - 1).add(nums[i]);
        }

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int sizeI = increasing.get(i).size();
                int sizeJ = increasing.get(j).size();
                if (nums[i] > nums[j] && sizeI < sizeJ + 1) {
                    increasing.set(i, new ArrayList<>(increasing.get(j)));
                    increasing.get(i).add(nums[i]);
                    maxLen = Math.max(maxLen, sizeJ + 1);
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for(List<Integer> list : increasing) {
            if (list.size() == maxLen) {
                res.add(list);
            }
        }
        return res;
    }
}
