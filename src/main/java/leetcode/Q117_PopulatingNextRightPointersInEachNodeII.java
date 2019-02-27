package leetcode;

/**
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class Q117_PopulatingNextRightPointersInEachNodeII {
    public TreeLinkNode connect(TreeLinkNode root) {
        if (root == null) {
            return null;
        }

        TreeLinkNode nextLevelHead = null;
        TreeLinkNode prev = null;
        TreeLinkNode node = root;
        while (node != null) {
            while (node != null) {
                if (node.left != null) {
                    if (prev == null) {
                        nextLevelHead = node.left;
                    } else {
                        prev.next = node.left;
                    }
                    prev = node.left;
                }
                if (node.right != null) {
                    if (prev == null) {
                        nextLevelHead = node.right;
                    } else {
                        prev.next = node.right;
                    }
                    prev = node.right;
                }
                node = node.next;
            }
            node = nextLevelHead;
            prev = null;
            nextLevelHead = null;
        }
        return root;
    }
}
