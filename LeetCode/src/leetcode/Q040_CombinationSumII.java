package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C 
 where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
    The solution set must not contain duplicate combinations.

 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6] 
 */
public class Q040_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0)
			return new LinkedList();

		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		sum(candidates, 0, target, res, new ArrayList());

		return res;
	}

	private void sum(int[] can, int startIdx, int target, List<List<Integer>> res, ArrayList<Integer> comb) {
		if (target == 0) {
			List<Integer> list = new LinkedList();
			list.addAll(comb);
			res.add(list);
			return;
		}

		for (int i = startIdx; i < can.length; i++) {
			if (target >= can[i]) {
				comb.add(can[i]);
				sum(can, i + 1, target - can[i], res, comb);
				comb.remove(comb.size() - 1);
			} else {
				break;
			}
			while (i < can.length - 1 && can[i] == can[i + 1]) {
				i++;
			}
		}
	}
}
