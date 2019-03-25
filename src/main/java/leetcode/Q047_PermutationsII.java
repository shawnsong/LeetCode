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
		permute(nums, new ArrayList<>(), new boolean[nums.length], res);
		return res;
	}
	
	private void permute(int[] nums, ArrayList<Integer> solution, boolean[] used, List<List<Integer>> res) {
		if (solution.size() == nums.length) {
			res.add(new LinkedList<>(solution));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
				continue;
			}

			used[i] = true;
			solution.add(nums[i]);
			permute(nums, solution, used, res);
			solution.remove(solution.size() - 1);
			used[i] = false;
		}
	}

}
