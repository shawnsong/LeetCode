package leetcode;

import java.util.Set;


/*
 *  Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code". 
 * 
 */


public class Q139_WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {
		
		boolean[] dp = new boolean[s.length() + 1];
		
		//Arrays.fill(dp, true);
		dp[s.length()] = true;
		
		for (int i = s.length(); i >= 0; i--) {
			if (dp[i] == false)
				continue;
			for (int j = i - 1; j >= 0; j--) {
				String word=  s.substring(j, i);
				if (dp[i] == true && wordDict.contains(word)) {
					dp[j] = true;
				}
			}
		}
		
		return dp[0];
	}
}
