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

        if (s ==null || s.length() == 0) {
            return false;
        }


        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if(!dp[i] ) {
                continue;
            }
            for (int j = i + 1; j <= len; j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
	}
}
