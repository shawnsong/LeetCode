package leetcode;

public class Q222_CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		
		int height = getHeight(root);
		int sum = countNodes(root, height);
		return sum;
	}
	
	public int countNodes(TreeNode root, int height) {
		if (root == null)
			return 0;
		
		int rightHeight = getHeight(root.right);
		if (rightHeight == height - 1) {
			int sum =  (1 << (height - 1)); // left perfect complete tree + root node
			sum += countNodes(root.right, height - 1);
			return sum;
		} else {
			int sum = (1 << (height - 2)); // right perfect complete tree + root node
			sum += countNodes(root.left, height - 1);
			return sum;
		}
	}
	
	private int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		
		int height = 0;
		TreeNode node = root;
		while (node != null) {
			node = node.left;
			height++;
		}
		
		return height;
	}
}
