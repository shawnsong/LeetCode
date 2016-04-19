package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
Thus, the itinerary must begin with JFK.

Note:

	If there are multiple valid itineraries, you should return the itinerary that has the 
	smallest lexical order when read as a single string. 
	For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
	All airports are represented by three capital letters (IATA code).
	You may assume all tickets form at least one valid itinerary.

Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order. 
 */
public class Q332_ReconstructItinerary {
	public static void main(String[] a) {
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		Q332_ReconstructItinerary o = new Q332_ReconstructItinerary();
		System.out.println(o.findItinerary(tickets));
	}
	public List<String> findItinerary(String[][] tickets) {
		HashMap<String, PriorityQueue<String>> map = new HashMap();
		
		for (int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			if (map.containsKey(from)) {
				map.get(from).add(to);
			} else {
				PriorityQueue<String> q = new PriorityQueue();
				q.add(to);
				map.put(from, q);
			}
		}
		
		String from = "JFK";
		List<String> res = new LinkedList();
		dfs(from, map, res);
		return res;
	}
	
	private void dfs(String from, HashMap<String, PriorityQueue<String>> map, List<String> res) {
		PriorityQueue<String> queue = map.get(from);
		if (queue == null || queue.size() == 0) {
			res.add(0, from);
			return;
		}
		
		
		while (!queue.isEmpty()) {
			String to = map.get(from).poll();
			dfs(to, map, res);
		}
		res.add(0, from);
	}
}
