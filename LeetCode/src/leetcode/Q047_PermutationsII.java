package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1]. 
 */
public class Q047_PermutationsII {
	public static void main(String[] arg) {
		Q047_PermutationsII o = new Q047_PermutationsII();
		List res = o.permuteUnique(new int[] {3,3,1,2,3,2,3,1});
		
		System.out.println(res);
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		
		List<List<Integer>> res = new LinkedList();
		permute(nums, 0, res);
		return res;
	}
	
	private void permute(int[] nums, int startIdx, List<List<Integer>> res) {
		if (startIdx == nums.length) {
			List<Integer> list = new LinkedList();
			for (int i = 0; i < nums.length; i++)
				list.add(nums[i]);
			res.add(list);
			return;
		}
		
		for (int i = startIdx; i < nums.length; i++) {
			if (hasDup(nums, startIdx, i))
				continue;
//			if (i > startIdx && nums[startIdx] == nums[i])
//				continue;
			swap(nums, startIdx, i);
			permute(nums, startIdx + 1, res);
			swap(nums, startIdx, i);
			
		}
	}
	
	private boolean hasDup(int[] nums, int startIdx, int endIdx) {
		for (int i = startIdx; i < endIdx; i++) {
			if (nums[i] == nums[endIdx])
				return true;
		}
		return false;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
