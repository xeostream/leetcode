/*
 * Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * Given:
 *       1
 *      / \
 *     2   5
 *    / \   \
 *   3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Solution55 {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return ;
		flatten(root.left);
		flatten(root.right);
		if (root.left == null) return ;
		TreeNode node = root.left;
		TreeNode right = root.right;
		root.right = root.left;
		while (node.right != null)
			node = node.right;
		node.right = right;
		root.left = null;
	}
}
