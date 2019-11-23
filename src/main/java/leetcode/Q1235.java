package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));

        ArrayList<Integer> ends = new ArrayList<>();
        ArrayList<Integer> profits = new ArrayList<>();
        ends.add(0);
        profits.add(0);
        for (Job job : jobs) {
            int prevIdx = search(ends, job.start + 1);
            // int preIdx = Collections.binarySearch(ends, job.start + 1);
            // if (preIdx < 0) {
            //     preIdx = -preIdx - 1;
            // }
            // preIdx--;
            prevIdx--;

            int curProfit = profits.get(prevIdx) + job.profit;
            int maxProfit = profits.get(profits.size() - 1);
            if (curProfit > maxProfit) {
                ends.add(job.end);
                profits.add(curProfit);
            }
        }
        return profits.get(profits.size() - 1);
    }

    int search(ArrayList<Integer> nums, int target) {
        int left = 0, right = nums.size() -1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                right = mid - 1;
                res = mid;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res == -1 ? left : res;
    }

    class Job {
        int start;
        int end;
        int profit;
        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }
}
