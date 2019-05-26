package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(0, root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            res.add(0, root.val);
            root = root.left;
        }
        return res;
    }
}
