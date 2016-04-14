package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    For the return value, each inner list's elements must follow the lexicographic order.
    All inputs will be in lower-case.

 */
public class Q049_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List res = new LinkedList();
		
		HashMap<String, PriorityQueue<String>> map = new HashMap();
		for (int i = 0; i < strs.length; i++) {
			char[] s = strs[i].toCharArray();
			Arrays.sort(s);
			String key = new String(s);
			if (map.containsKey(key)) {
				map.get(key).add(strs[i]);
			} else {
				PriorityQueue<String> heap = new PriorityQueue();
				heap.add(strs[i]);
				map.put(key, heap);
			}
		}
		
		for (PriorityQueue<String> q : map.values()) {
			List<String> list = new LinkedList();
			while (!q.isEmpty()) {
				list.add(q.poll());
			}
			res.add(list);
		}
		return res;
	}
}
