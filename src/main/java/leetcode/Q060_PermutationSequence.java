package leetcode;

import java.util.ArrayList;

/*
 The set [1,2,3,бн,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */
public class Q060_PermutationSequence {
	public static void main(String[] a) {
		String res = getPermutation(8, 8590);
		System.out.println(res);
	}
	public static String getPermutation(int n, int k) {
		int[] factorial = new int[10];
		factorial[1] = 1;
		for (int i = 2; i <= 9; i++)
			factorial[i] = factorial[i - 1] * i;

		int sectIdx = 0;
		StringBuilder sb = new StringBuilder();
		k--;

		ArrayList<Integer> digits = new ArrayList();
		for (int i = 1; i <= n; i++)
			digits.add(i);

		int i = n - 1;
		for (; i >= 0; i--) {
			if (k == 0) {
				for (int j = 0; j < digits.size(); j++)
					sb.append(digits.get(j));
				break;
			}
			int size = factorial[i];
			sectIdx = k / size;
			sb.append(digits.remove(sectIdx));
			k = k - (size * sectIdx);
			
		}

		return sb.toString();
	}
}
