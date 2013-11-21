/*
 * Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution60 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		int len = num.length;
		if (len == 0) return null;
		int mid = len / 2;
		TreeNode root = new TreeNode(num[mid]);
		if (0 < mid)
			root.left = sortedArrayToBST(num, 0, mid - 1);
		if (mid < len - 1)
			root.right = sortedArrayToBST(num, mid + 1, len - 1);
		return root;
	}
	
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBST(num, start, mid - 1);
		node.right = sortedArrayToBST(num, mid + 1, end);
		return node;
	}
	
	public static void main(String ...args) {
		Solution60 s60 = new Solution60();
		int[] num = {1,2};
		TreeNode root = s60.sortedArrayToBST(num);
		System.out.println(root.val+" "+root.left.val);
	}
}
