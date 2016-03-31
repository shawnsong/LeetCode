package leetcode;

/*
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
*/
public class Q070_ClimbingStairs {

	public int climbStairs(int n) {
		if (n <= 2)
			return n;
		
		
		int prev2 = 1;
		int prev1 = 2;
		
		int total = 0;
		for (int i = 3; i <= n; i++) {
			total = prev2 + prev1;
			prev2 = prev1;
			prev1 = total;
		}
		
		return total;
	}
}
