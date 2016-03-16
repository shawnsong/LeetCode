package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.
	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
	which is expressed as a pair: [0,1]
	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	
	For example:
	
	2, [[1,0]]
	
	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
	
	2, [[1,0],[0,1]]
	
	There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take 
	course 0 you should also have finished course 1. So it is impossible.
 */

public class Q207_CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		return canFinishBfs(numCourses, prerequisites);
	}
	
	/* BFS: The idea is to count in-degrees of each vertex. Then we start with vertexes of zero in-degree (no prerequisites)
	 * and decrease their descendants' in-degrees. We increment the counter when the in-degree of a vertex is 
	 * decreased to zero and add into queue. If there is a loop, then at least one vertex' in-degree 
	 * will be greater than zero.
	 * 0 ->  1  -> 2
	 *       ^\   V
	 *          3
	 *  
	 */
	public boolean canFinishBfs(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0)
			return true;
		
		ArrayList<Integer>[] nextCourses = new ArrayList[numCourses];
		for (int i = 0; i < nextCourses.length; i++)
			nextCourses[i] = new ArrayList();
		
		int[] inDegree = new int[numCourses];
		
		for (int i = 0; i < prerequisites.length; i++) {
			int pre = prerequisites[i][1];
			int next = prerequisites[i][0];
			nextCourses[pre].add(next);
			
			inDegree[next]++;
		}
		
		int count = 0;
		Queue<Integer> queue = new LinkedList();
		for (int i = 0; i < nextCourses.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
				count++;
			}
		}
		
		while (!queue.isEmpty()) {
			int pre = queue.poll();
			ArrayList<Integer> nexts = nextCourses[pre];
			for (int n : nexts) {
				inDegree[n]--;
				if (inDegree[n] == 0) {
					queue.add(n);
					count++;
				}
			}
		}
		
		return count == numCourses;
	}
	
	
	/*
	 * DFS - Topological Sort: The idea is to use DFS to traverse the graph. If there is NO loops in the graph,
	 * then all courses can be finished.
	 */
	public boolean canFinishDfs(int numCourses, int[][] prerequisites) {

		ArrayList<Integer>[] nextCourses = new ArrayList[numCourses];
		
		for (int i = 0; i < numCourses; i++) 
			nextCourses[i] = new ArrayList();
		
		for (int i = 0; i < prerequisites.length; i++) {
			int pre = prerequisites[i][1];
			int next = prerequisites[i][0];
			nextCourses[pre].add(next);
		}
		for (int i = 0; i < numCourses; i++) {
			boolean can = canFinishDfs(i, nextCourses, new HashSet(), new boolean[numCourses]);
			if (can == false)
				return false;
		}
		return true;
	}
	
	public boolean canFinishDfs(int parent, ArrayList<Integer>[] nextCourses, HashSet<Integer> parents, boolean[] visited) {
		// found a loop
		if (parents.contains(parent))
			return false;
		
		if (visited[parent])
			return true;
		
		ArrayList<Integer> nexts = nextCourses[parent];
		parents.add(parent);
		for (int n : nexts) {
			boolean can = canFinishDfs(n, nextCourses, parents, visited);
			if (can == false)
				return false;
		}
		parents.remove(parent);
		visited[parent] = true;
		return true;
	}
}
