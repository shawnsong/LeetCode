package leetcode;

import java.util.Stack;

/**
 * To solve 321, let's solve a simpler version of only 1 array
 * The solution to this problem is Greedy with the help of stack. The recipe is as following
 *
 * Initialize a empty stack
 * Loop through the array nums
 * pop the top of stack if it is smaller than nums[i] until
 * stack is empty
 * the digits left is not enough to fill the stack to size k
 * if stack size < k push nums[i]
 * Return stack
 */
public class Q321_Sub1 {
    public String maxArray(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0;  i< nums.length; i++) {
            while (n - i + stack.size() > k && !stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
