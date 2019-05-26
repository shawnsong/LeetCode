package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Question: Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

/*
	OJ's undirected graph serialization:
	
	Nodes are labeled uniquely.
	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	
	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	
	    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	    Second node is labeled as 1. Connect node 1 to node 2.
	    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	
	Visually, the graph looks like the following:
	
	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/
 */

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
	
	@Override
	public String toString() {
		return String.valueOf(label);
	}
}

public class Q133_CloneGraph {

	// bfs
	public UndirectedGraphNode cloneGraphBfs(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
		
		Queue<UndirectedGraphNode> queue = new LinkedList();
		queue.add(node);
		
		UndirectedGraphNode root = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			
			UndirectedGraphNode newNode = null; 
			if (map.containsKey(node))
				newNode = map.get(node);
			else {
				newNode = new UndirectedGraphNode(node.label);
				map.put(node, newNode);
			}
			if (root == null) {
				root = newNode;
			}
			for (UndirectedGraphNode nei : node.neighbors) {
				UndirectedGraphNode newNei = null;
				if (map.containsKey(nei)) {
					newNei = map.get(nei);
				} else {
					newNei = new UndirectedGraphNode(nei.label);
					map.put(nei, newNei);
					queue.add(nei);
				}
				newNode.neighbors.add(newNei);
			}
		}
		return root;
	}

	public UndirectedGraphNode bfs(UndirectedGraphNode node) {
		if (node == null) return null;

		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

		while (!queue.isEmpty()) {
			UndirectedGraphNode root = queue.poll();

			UndirectedGraphNode newRoot;
			if (map.containsKey(node)) {
				newRoot = map.get(root);
			} else {
				newRoot = new UndirectedGraphNode(root.label);
			}
			map.put(root, newRoot);

			for (UndirectedGraphNode nei : root.neighbors) {
				if (map.containsKey(nei)) {
					newRoot.neighbors.add(map.get(nei));
				} else {
					UndirectedGraphNode newNei = new UndirectedGraphNode(nei.label);
					map.put(nei, newNei);
					queue.add(nei);
					newRoot.neighbors.add(newNei);
				}
			}
		}
		return map.get(node);
	}
	
	
	// dfs 
	public UndirectedGraphNode cloneGraphDfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> copy) {
		if (node == null)
			return null;
		
		if (copy.containsKey(node))
			return copy.get(node);
		
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		copy.put(node, newNode);
		for (UndirectedGraphNode nei : node.neighbors) {
			UndirectedGraphNode newNei = null;
			if (copy.containsKey(nei))
				newNei = copy.get(nei);
			else {
				newNei = cloneGraphDfs(nei, copy);
				copy.put(nei, newNei);
			}
			newNode.neighbors.add(newNei);
		}
		
		return newNode;
	}
}
