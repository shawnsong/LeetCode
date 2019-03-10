package leetcode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two
 * nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 */
public class Q236_LowestCommonAncestorOfBinaryTree {

    // this method assumes p/q exists in the tree
    public TreeNode lcaWithCorrectInput(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            return p != null ? p : q;
        }

        TreeNode left = lcaWithCorrectInput(root, p, q);
        TreeNode right = lcaWithCorrectInput(root, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // this method can deal with p/q not in the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LcaResult res = lca(root, p, q);
        if (res.found) {
            return res.node;
        }
        return null;
	}


	private LcaResult lca(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null) {
	        return new LcaResult(false, null);
        }
        if (p == q || p == null || q == null) {
            return new LcaResult(true, p != null ? p : q);
        }

        LcaResult left = lca(root.left, p, q);
        if (left.found) {
            return left;
        }
        LcaResult right = lca(root.right, p, q);
        if (right.found) {
            return right;
        }

        if (left.node != null && right.node != null) {
            return new LcaResult(true, root);
        } else if (p == root || q == root) {
            boolean found = left.node != null || right.node != null;
            return new LcaResult(found, root);
        } else {
            return new LcaResult(false, left.node != null ? left.node : right.node);
        }
    }

    class LcaResult {
	    boolean found;
	    TreeNode node;
	    LcaResult(boolean found, TreeNode n) {
	        this.found = found;
	        this.node = n;
        }
    }
}
