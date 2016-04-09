package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Find all possible combinations of k numbers that add up to a number n, given that only 
 numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.

 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Q216_CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new LinkedList();
		combination(k, n, 1, res, new ArrayList());
		return res;
	}
	
	private void combination(int k, int n, int start, List<List<Integer>> res, ArrayList<Integer> comb) {
		if (k == 0 && n == 0) {
			List<Integer> list = new LinkedList();
			list.addAll(comb);
			res.add(list);
			return;
		}
		if (k == 0 && n != 0)
			return;
		
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(k - 1, n - i, i+1, res, comb);
			comb.remove(comb.size() - 1);
		}
	}
}
