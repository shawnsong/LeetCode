package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 A group of two or more people wants to meet and minimize the total travel distance. 
 You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
 The distance is calculated usingManhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 For example, given three people living at (0,0), (0,4), and(2,2):
 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0

 The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */
public class Q296_BestMeetingPoint {
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
		Q296_BestMeetingPoint o = new Q296_BestMeetingPoint();
		int step = o.minTotalDistance(grid);
		System.out.print(step);
		
	}
	
	public int minTotalDistance(int[][] grid) {
		
		if (grid == null || grid.length == 0)
			return 0;
		
		List<Integer> listX = new ArrayList();
		List<Integer> listY = new ArrayList();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					listX.add(i);
					listY.add(j);
				}
			}
		}
		
		int stepsX = 0;
		// listX is sorted
		int midX = listX.get(listX.size() / 2);
		for (int i = 0; i < listX.size(); i++)
			stepsX += Math.abs(listX.get(i) - midX);
		
		// listY is unsorted
		Collections.sort(listY);
		int midY = listY.get(listY.size() / 2);
		int stepsY = 0;
		for (int i = 0; i < listY.size(); i++)
			stepsY += Math.abs(listY.get(i) - midY);
		
		return stepsX + stepsY;
	}
}
