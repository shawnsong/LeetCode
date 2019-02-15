package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.

Notes:

    You must use only standard operations of a queue -- which means only push to back, 
    peek/pop from front, size, and is empty operations are valid.
    
    Depending on your language, queue may not be supported natively. You may simulate 
    a queue by using a list or deque (double-ended queue), as long as you use 
    only standard operations of a queue.
    
    You may assume that all operations are valid (for example, no pop or top operations 
    will be called on an empty stack).

 */
public class Q225_ImplementStackUsingQueues {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	Queue cur = q1;

	// Push element x onto stack.
	public void push(int x) {

		if (cur == q1) {
			q1.add(x);
		} else {
			q2.add(x);
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (cur == q2) {
			while (q2.size() > 1) {
				q1.add(q2.remove());
			}
			q2.remove();
			cur = q1;
		} else {
			while (q1.size() > 1) {
				q2.add(q1.remove());
			}
			q1.remove();
			cur = q2;
		}
	}

	// Get the top element.
	public int top() {
		int top = 0;
		if (cur == q2) {
			while (q2.size() > 1) {
				q1.add(q2.remove());
			}
			top = q2.remove();
			q1.add(top);
			cur = q1;
		} else {
			while (q1.size() > 1) {
				q2.add(q1.remove());
			}
			top = q1.remove();
			q2.add(top);
			cur = q2;
		}
		return top;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.size() == 0 && q2.size() == 0;
	}
}
