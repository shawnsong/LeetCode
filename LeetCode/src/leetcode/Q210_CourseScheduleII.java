package leetcode;

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
