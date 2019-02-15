package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,3], a solution is:

 [
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
 ]
 */
public class Q078_Subsets {
	// bit manipulation
	public List<List<Integer>> subsets1(int[] nums) {
		int len = nums.length;
		
		int size = 1 << len;
		List<List<Integer>> res = new LinkedList();
		
		for (int i = 0; i < size; i++) {
			int j = i;
			ArrayList<Integer> list = new ArrayList();
			int pos = 0;
			int bit = 1 << pos;
			while (j > 0) {
				while ((j & bit) == 0) {
					pos++;
					bit = pos << 1;
				}
				list.add(nums[pos]);
				j = j & (j - 1);
			}
			res.add(list);
		}
		return res;
	}
	
	
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		
		int len = nums.length;
		List<List<Integer>> res = new LinkedList();
		res.add(new LinkedList());
		// for different length
		for (int i = 1; i <= len; i++) {
			subsets(nums, 1, i, res, new ArrayList());
		}
		return res;
	}
	
	// {1,2,3}
	// backtrack
	public void subsets(int[] nums, int startIdx, int len, List<List<Integer>> res, ArrayList<Integer> set) {
		if (set.size() == len) {
			List<Integer> list = new LinkedList();
			list.addAll(set);
			res.add(list);
			return;
		}
		
		for (int i = startIdx; i <= nums.length; i++) {
			set.add(i);
			subsets(nums, i + 1, len, res, set);
			set.remove(set.size() - 1);
		}
	}
	
	
}
