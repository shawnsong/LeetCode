package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 *  where the candidate numbers sums to T.
 *
 *  The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 *  All numbers (including target) will be positive integers.
 *  Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <=... ak).
 *  The solution set must not contain duplicate combinations.
 *  For example, given candidate set 2,3,6,7 and target 7,
 *  A solution set is:
 *  [7]
 *  [2, 2, 3]
 */
public class Q039_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<>();
		if (candidates == null || candidates.length == 0) return res;
		Arrays.sort(candidates);
		combine(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	private void combine(int[] nums, int target, int startIdx, ArrayList<Integer> solution, List<List<Integer>> res) {
		if (target == 0 && solution.size() > 0) {
			res.add(new LinkedList<>(solution));
			return;
		}
		if (target < nums[startIdx]) return;

		for (int i = startIdx; i < nums.length; i++) {
			solution.add(nums[i]);
			combine(nums, target - nums[i], i, solution, res);
			solution.remove(solution.size() - 1);
		}
	}
}
