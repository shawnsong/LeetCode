package leetcode;

import java.util.Arrays;

/*
 You are playing the following Nim Game with your friend: 
 There is a heap of stones on the table, each time one of you take turns to 
 remove 1 to 3 stones. The one who removes the last stone will be the winner. 
 You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. 
 Write a function to determine whether you can win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then 
 you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will 
 always be removed by your friend.

 Hint:

 If there are 5 stones in the heap, could you figure out a way to remove the stones 
 such that you will always be the winner?
 */
public class Q292_NimGame {

	/*
	 *  note: to win the game, the first player will need to keep the condition
	 *  that the number of left stones is always multiple times of 4.
	 *  if the initial stones is multiple times of 4, the the first player can never win. 
	 */
    public boolean canWinNim(int n) {
        if (n == 0) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        boolean prev3 = true;   // dp1
        boolean prev2 = true;   // dp2
        boolean prev1 = true;   // dp3
        boolean cur = false;
        for (int i = 4; i <= n; i++) {
            if (prev1 && prev2 && prev3) {
                cur = false;
            } else {
                cur = true;
            }
            prev3 = prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }

    public boolean canWin2(int n) {
        return n % 4 != 0;
    }
}
