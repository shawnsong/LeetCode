package leetcode;

public class Q124_BinaryTreeMaximumPathSum {
    int maxValue = Integer.MIN_VALUE;
    
    public static void main(String[] a) {
        Q124_BinaryTreeMaximumPathSum o = new Q124_BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        int m = o.maxPath(root);
        System.out.println(m);
    }
    
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxValue;
    }
    
    public int maxPath(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftSum = Math.max(0, maxPath(root.left));
        int rightSum = Math.max(0, maxPath(root.right));
        
        int sum = root.val + leftSum + rightSum;
        maxValue = Math.max(maxValue, sum);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
