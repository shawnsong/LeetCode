package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class Q118_PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new LinkedList();
		if (numRows <= 0)
			return ret;

		List<Integer> prev = new LinkedList();
		prev.add(1);
		ret.add(prev);
		for (int i = 1; i < numRows; i++) {
			List<Integer> cur = new LinkedList();
			cur.add(1);
			Iterator<Integer> it = prev.iterator();
			int prevVal = it.next();

			while (it.hasNext()) {
				int curVal = it.next();
				int val = prevVal + curVal;
				cur.add(val);
				prevVal = curVal;
			}
			cur.add(1);

			ret.add(cur);
			prev = cur;
		}
		return ret;
	}
}
