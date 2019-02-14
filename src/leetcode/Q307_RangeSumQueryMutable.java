package leetcode;

/*
 Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.
 */
class SegmentTreeNode {
	SegmentTreeNode left;
	SegmentTreeNode right;
	int leftIdx;
	int rightIdx;
	int val;

	public SegmentTreeNode(int l, int r, int v) {
		leftIdx = l;
		rightIdx = r;
		val = v;
	}
}

public class Q307_RangeSumQueryMutable {

	SegmentTreeNode root;
	private int[] nums;

	public static void main(String[] args) {
		// [7,2,7,2,0],update(4,6),update(0,2),update(0,9),sumRange(4,4),update(3,8),sumRange(0,4),update(4,1),sumRange(0,3),sumRange(0,4),update(0,4)
		int[] nums = { 7, 2, 7, 2, 6 };
		Q307_RangeSumQueryMutable o = new Q307_RangeSumQueryMutable(nums);

		o.update(4, 6);
		o.update(0, 2);
		o.update(0, 9);
		o.update(3, 8);
		int sum = o.sumRange(0, 4);
		System.out.println(sum);
		// o.update(1, 2);
		// System.out.println(o.sumRange(1, 2));
	}

	public Q307_RangeSumQueryMutable(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
		this.nums = nums;
	}

	void update(int i, int val) {
		int diff = val - nums[i];
		nums[i] = val;
		update(root, i, diff);
	}

	public int sumRange(int i, int j) {
		int sum = getSum(root, i, j);
		return sum;
	}

	// tree related methods
	private int getSum(SegmentTreeNode root, int i, int j) {
		if (root == null)
			return 0;
		if (root.leftIdx > j || root.rightIdx < i)
			return 0;

		if (root.leftIdx >= i && root.rightIdx <= j)
			return root.val;

		int sum = 0;
		// if (root.leftIdx <= i && i <= root.rightIdx ) {
		sum += getSum(root.left, i, j);
		sum += getSum(root.right, i, j);
		// }

		return sum;
	}

	private void update(SegmentTreeNode root, int i, int diff) {
		if (root == null)
			return;
		if (root.leftIdx <= i && root.rightIdx >= i) {
			root.val += diff;
			update(root.left, i, diff);
			update(root.right, i, diff);
		}
	}

	private SegmentTreeNode buildTree(int[] nums, int startIdx, int endIdx) {
		if (startIdx > endIdx)
			return null;
		else if (startIdx == endIdx) {
			return new SegmentTreeNode(startIdx, startIdx, nums[startIdx]);
		} else {
			// start < end
			int midIdx = startIdx + (endIdx - startIdx) / 2;
			SegmentTreeNode left = buildTree(nums, startIdx, midIdx);
			SegmentTreeNode right = buildTree(nums, midIdx + 1, endIdx);
			int sum = left.val + right.val;
			SegmentTreeNode root = new SegmentTreeNode(startIdx, endIdx, sum);
			root.left = left;
			root.right = right;
			return root;
		}

	}

	private int getSum(int[] nums, int leftIdx, int rightIdx) {
		int ret = 0;
		for (int i = leftIdx; i <= rightIdx; i++) {
			ret += nums[i];
		}
		return ret;
	}
}
