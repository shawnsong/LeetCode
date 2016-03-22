package leetcode;

/*
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses 
 you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to 
 finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
 So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
 Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. 
 Another correct ordering is[0,2,1,3]
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q210_CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		ArrayList<Integer>[] nexts = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			nexts[i] = new ArrayList();
		int[] inDegrees = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int from = prerequisites[i][1];
			int to = prerequisites[i][0];
			if (nexts[from] == null)
				nexts[from] = new ArrayList();
			nexts[from].add(to);
			inDegrees[to]++;
		}

		List<Integer> res = new LinkedList();
		ArrayDeque<Integer> queue = new ArrayDeque();
		int count = 0;
		for (int i = 0; i < nexts.length; i++) {
			if (inDegrees[i] == 0) {
				queue.add(i);
				res.add(i);
				count++;
			}
		}

		while (!queue.isEmpty()) {
			int pre = queue.poll();
			ArrayList<Integer> next = nexts[pre];
			for (int n : next) {
				inDegrees[n]--;
				if (inDegrees[n] == 0) {
					queue.add(n);
					res.add(n);
					count++;
				}
			}
		}

		if (count == numCourses) {
			int[] ret = new int[numCourses];
			int idx = 0;
			for (int i : res) {
				ret[idx] = i;
				idx++;
			}
			return ret;
		} else
			return new int[0];
	}
}
