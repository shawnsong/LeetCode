package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C 
 where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 
 */
public class Q039_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		
		List res = new LinkedList();
		combine(candidates, 0, target, res, new ArrayList());
		return res;
	}
	
	private void combine(int[] candidates, int startIdx, int t, List<List<Integer>> res, ArrayList<Integer> comb) {
		if (t == 0) {
			List<Integer> list = new LinkedList();
			list.addAll(comb);
			res.add(list);
			return;
		}
		
		for (int i = startIdx; i < candidates.length; i++) {
			if (candidates[i] <= t) {
				comb.add(candidates[i]);
				combine(candidates, i, t - candidates[i], res, comb);
				comb.remove(comb.size() - 1);
			} else
				break;
		}
	}
}
