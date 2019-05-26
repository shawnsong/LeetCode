package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
 *  where the candidate numbers sums to T.
 *
 *  Each number in C may only be used once in the combination.
 *
 *  Note:
 *
 *     All numbers (including target) will be positive integers.
 *     Elements in a combination (a1, a2, .. , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 *     The solution set must not contain duplicate combinations.
 *
 *  For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 *  A solution set is:
 *  [1, 7]
 *  [1, 2, 5]
 *  [2, 6]
 *  [1, 1, 6]
 */
public class Q040_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0)
			return new LinkedList();

		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		combine(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

	private void combine(int[] nums, int target, int startIdx, ArrayList<Integer> solution, List<List<Integer>> res) {
		if (target == 0 && solution.size() > 0) {
			res.add(new LinkedList<>(solution));
			return;
		}

		if (target < 0) return;

		for (int i = startIdx; i < nums.length; i++) {
			if (i > startIdx && nums[i] == nums[i - 1]) continue;
			solution.add(nums[i]);
			combine(nums, target - nums[i], i + 1, solution, res);
			solution.remove(solution.size() - 1);
		}
	}
}
