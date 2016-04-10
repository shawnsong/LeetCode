package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4]
 ]
 */
public class Q077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList();
		if (k > n) {
			return res;
		}
		combine(n, k, 1, res, new ArrayList());
		return res;
	}
	
	private void combine(int n, int k, int startIdx, List<List<Integer>>res, ArrayList<Integer> comb) {
		if (k == comb.size()) {
			List<Integer> list = new LinkedList();
			list.addAll(comb);
			res.add(list);
			return;
		}
		
		for (int i = startIdx; i <= n; i++) {
			comb.add(i);
			combine(n, k, i + 1, res, comb);
			comb.remove(comb.size() - 1);
		}
	}
}
