package leetcode;

import java.util.ArrayList;

/*
 This is a follow up of Shortest Word Distance. The only difference is now you are 
 given the list of words and your method will be called repeatedly many times with 
 different parameters. How would you optimize it?

 Design a class which receives a list of words in the constructor, and implements 
 a method that takes two words word1 and word2 and return the shortest distance 
 between these two words in the list.

 For example,

 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "coding¡±, word2 = "practice¡±, return 3. Given word1 = "makes", word2 = "coding", return 1.

 Note
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Q244_ShortestWordDistanceII {

	public int shortestDistance(String[] words, String word1, String word2) {
		ArrayList<Integer> idx1 = new ArrayList();
		ArrayList<Integer> idx2 = new ArrayList();

		int dist = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				idx1.add(i);
			else if (words[i].equals(word2))
				idx2.add(i);
		}
		int i = 0;
		int j = 0;
		while (i <= idx1.size() && j <= idx2.size()) {
			dist = Math.min(dist, idx1.get(i) - idx2.get(j));
			if (idx1.get(i) < idx2.get(j))
				i++;
			else
				j++;
		}
		
		return dist;
	}
}
