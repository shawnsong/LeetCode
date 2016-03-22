package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, such that:
	Only one letter can be changed at a time
	Each intermediate word must exist in the word list
	
For example,
	
Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
Note:
	
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

 */
public class Q_127WordLadder {

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0)
			return 0;
		if (beginWord.equals(endWord))
			return 0;
		if (beginWord.length() != endWord.length())
			return 0;
		Queue<String> queue = new LinkedList();
		HashSet<String> visited = new HashSet();
		visited.add(beginWord);
		queue.add(beginWord);
		int count = 1;
		while (!queue.isEmpty()) {
			
			Queue<String> newQueue = new LinkedList();
			while (!queue.isEmpty()) {
				String word = queue.poll();
				List<String> mutates = getMutateWord(word, visited);
				for (String m : mutates) {
					if (m.equals(endWord)) {
						count++;
						return count;
					} else {
						if (wordList.contains(m)) {
							visited.add(m);
							newQueue.add(m);
						}
					}
				}

			}
			if (newQueue.size() != 0) {
				queue = newQueue;
				count++;
			}
		}
		return 0;
	}
	
	public List<String> getMutateWord(String word, Set<String> visited) {
		if (word == null || word.length() == 0)
			return new LinkedList();
		List<String> res = new LinkedList();
		for (int i = 0; i < word.length(); i++) {
			
			char c = word.charAt(i);
			for (int j = 0; j < 26; j++) {
				StringBuilder sb = new StringBuilder();
				char nc = (char) (j + 'a');
				if (nc == c)
					continue;
				sb.append(word.substring(0, i)).append(nc + "").append(word.substring(i+1));
				if (visited.contains(sb.toString()))
					continue;
				res.add(sb.toString());
			}
		}
		return res;
	}
}
