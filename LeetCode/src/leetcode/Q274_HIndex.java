package leetcode;

import java.util.Arrays;

/*
 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function 
 to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have 
at least h citations each, and the other N - h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each 
of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with 
at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

    An easy approach is to sort the array first.
    What are the possible values of h-index?
    A faster approach is to use extra space.

 */
public class Q274_HIndex {
	
	public int hIdx(int[] citations) {
		int[] citeCount = new int[citations.length];
		
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] > 0) {
				citeCount[Math.min(citations[i] - 1, citations.length - 1)]++;
			}
		}
		
		int hIdx = 0;
		int sum = 0;
		for (int i = citeCount.length - 1; i >= 0 ; i++) {
			sum += citeCount[i];
			if (sum > i)
				return i;
		}
		return 0;
	}
	
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		
		int hIdx = 0;
		for (int i = citations.length - 1; i >= 0; i--) {
			int cite = Math.min(citations[i], citations.length);
			if (cite > hIdx)
				hIdx++;
		}
		return hIdx;
	}
}
