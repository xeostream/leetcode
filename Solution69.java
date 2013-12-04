/*
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class Solution69 {
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		return rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean rec(TreeNode root, int min, int max) {
		if (root == null) return true;
		if (root.val <= min || root.val >= max) return false;
		return rec(root.left, min, root.val) && rec(root.right, root.val, max);
	}

	public static void main(String... args) {
		Solution69 s69 = new Solution69();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(0);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		System.out.println(s69.isValidBST(root));
	}
}
