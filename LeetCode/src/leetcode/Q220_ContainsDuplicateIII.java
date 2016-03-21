package leetcode;

import java.util.HashMap;

/*
 Given an array of integers, find out whether there are two distinct indices i and j in the array 
 such that the difference between nums[i] and nums[j] is at most t and the difference 
 between i and j is at most k.
 */

/*
 * Note: 
 * 1. because we have maximum difference of t, so the bucket size should be t+1
 * 2. we use long and map all numbers to Integer.MIN_VALUE to avoid negative number issues.
 * 	  i.e bucket size is 5, the numbers from 0 to 4 will map to bucket 0. However -1 to -4 will be 
 *    in the same bucket as well because -1 / 5 = 0; so we map Integer.MIN_VALUE to zero by 
 *    minus Integer.MIN_VALUE of each number and convert them to long type. 
 * 3. need to convert number to long type when doing any arithmetic operations
 * 4. edge cases are very very important  
 */
public class Q220_ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k < 0 || t < 0)
			return false;

		HashMap<Long, Long> buckets = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				long oldBucket = ((long)nums[i - k - 1] - Integer.MIN_VALUE)
						/ ((long)t + 1);
				buckets.remove(oldBucket);
			}

			long remappedNum = (long)nums[i] - (long)Integer.MIN_VALUE;
			long bucket = (long) ((long)remappedNum / ((long)t + 1));
			if (buckets.containsKey(bucket))
				return true;
			if (buckets.containsKey(bucket + 1)
					&& Math.abs(buckets.get(bucket + 1) - remappedNum) <= t) {
				return true;
			}
			if (buckets.containsKey(bucket - 1)
					&& Math.abs(buckets.get(bucket - 1) - remappedNum) <= t) {
				return true;
			}

			buckets.put(bucket, remappedNum);
		}
		return false;
	}
}
