package leetcode;

public class Q270_ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        int res = root.val;
        double diff = Double.MAX_VALUE;

        while (root != null) {
            double tmp = Math.abs(target - root.val);
            if (tmp < diff) {
                diff = tmp;
                res = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }
        return res;
    }
}
