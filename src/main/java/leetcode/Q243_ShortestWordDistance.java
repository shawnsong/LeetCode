package leetcode;

/*
 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = ��coding��, word2 = ��practice��, return 3. Given word1 = "makes", word2 = "coding", return 1.

 Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Q243_ShortestWordDistance {

	public static int shortestDistance(String[] words, String word1, String word2) {
		
		int idx1 = -1;
		int idx2 = -1;
		
		int dis = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				idx1 = i;
			
			if (words[i].equals(word2))
				idx2 = i;
			
			if (idx1 != -1 && idx2 != -1)
				dis = Math.min(dis, Math.abs(idx1 - idx2));
		}
		
		return dis;
	}
}
