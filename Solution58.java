/*
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution58 {

	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left != null && root.right != null) {
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			return Math.min(left, right) + 1;
		}
		if (root.left != null)
			return minDepth(root.left) + 1;
		if (root.right != null)
			return minDepth(root.right) + 1;
		return 1;
	}
	
	public static void main(String ...args) {
		Solution58 s58 = new Solution58();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		System.out.println(s58.minDepth(root));
	}
}
