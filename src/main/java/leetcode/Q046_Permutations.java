package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Q046_Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res  = new LinkedList();
		permute(nums, 0, res);
		return res;
	}

	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		res.add(Arrays.asList(nums[0]));

		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> next = new LinkedList<>();
			for (int j = 0; j < res.size(); j++) {
				List<Integer> list = res.get(j);
				for (int k = 0; k <= list.size(); k++) {
					List<Integer> newList = new LinkedList<>(list);
					newList.add(k, nums[i]);
					next.add(newList);
				}
			}
			res = next;
		}
		return res;
	}
	
	public void permute(int[] nums, int startIdx, List<List<Integer>>res) {
		if (startIdx == nums.length) {
			List<Integer> list = new LinkedList();
			for (int i = 0; i < nums.length; i++)
				list.add(nums[i]);
			res.add(list);
			return;
		}
		for (int i = startIdx; i < nums.length; i++) {
			swap(nums, startIdx, i);
			permute(nums, startIdx + 1, res);
			swap(nums, startIdx, i);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
