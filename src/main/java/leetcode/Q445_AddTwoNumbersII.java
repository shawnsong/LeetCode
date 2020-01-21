package leetcode;

import java.util.Stack;

public class Q445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                stack1.push(n1.val);
                n1 = n1.next;
            }
            if (n2 != null) {
                stack2.push(n2.val);
                n2 = n2.next;
            }
        }
        ListNode next = null;
        ListNode cur = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = carry;
            sum += !stack1.isEmpty() ? stack1.pop() : 0;
            sum += !stack2.isEmpty() ? stack2.pop() : 0;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            }
            cur = new ListNode(sum);
            cur.next = next;
            next = cur;
        }
        if (carry == 1) {
            cur = new ListNode(1);
            cur.next = next;
        }
        return cur;
    }
}
