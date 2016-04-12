package leetcode;

import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent 
numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 */
public class Q120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> cur = triangle.get(i);
			List<Integer> next = triangle.get(i + 1);
			for (int j = 0; j < cur.size(); j++) {
				cur.set(j, Math.min(next.get(j), next.get(j + 1)) + cur.get(j) );
			}
		}
		
		return triangle.get(0).get(0);
	}
}
