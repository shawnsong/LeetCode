package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class Q090_SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList();
		res.add(new LinkedList());
		subsets(nums, 0, res, new ArrayList());

		// subset(nums, 0, res, new ArrayList());

		return res;
	}

	private void subsets(int[] nums, int startIdx, List<List<Integer>> res, ArrayList<Integer> comb) {
		if (startIdx >= nums.length) {
			return;
		}

		for (int i = startIdx; i < nums.length; i++) {

			comb.add(nums[i]);
			List<Integer> list = new LinkedList();
			list.addAll(comb);
			res.add(list);

			subsets(nums, i + 1, res, comb);
			comb.remove(comb.size() - 1);

			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}

	private void subset(int[] nums, int startIdx, List<List<Integer>> res, ArrayList<Integer> comb) {
		res.add(comb);

		for (int i = startIdx; i < nums.length; i++) {
			if (startIdx > 0 && nums[i] == nums[i - 1])
				continue;

			ArrayList<Integer> newComb = new ArrayList();
			newComb.addAll(comb);
			newComb.add(nums[i]);
			subset(nums, i + 1, res, newComb);
		}
	}
}
