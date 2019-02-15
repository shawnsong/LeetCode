package leetcode;

/*
 * What if the citations array is sorted in ascending order? Could you optimize your algorithm? 
 */
public class Q275_HIndexII {
	public int hIndex(int[] citations) {
		// use number density to solve
		int low = 0;
		int high = citations.length - 1;
		int len = citations.length;

		int hIdx = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (citations[mid] >= len - mid) {
				/* if the citations[i] is greater than the number of papers (len - i) after this paper, 
				 * it means the hIdx is at least (len - i), we continue search left, otherwise we search right.
				 * Explain:
				 * because the array is sorted, so we have citations[i+1] >= citation[i]. 
				 * len - i is the number of papers after ith paper(including the ith paper)
				 * if citations[i] >= len - i, then citations[i], citations[i + 1].... citations[n - 1] are 
				 * all greater than len - i, so the hidx is at least (len-i);
				 */
				high = mid - 1;
				hIdx = len- mid;
			} else {
				low = mid + 1;
			}
		}

		return hIdx;
	}
}
