/*
 * Maximum Depth of Binary Tree
 */
public class Solution8 {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = getDepth(root.left, 1);
		int right = getDepth(root.right, 1);
		return (left>right?left:right);
	}
	
	public int getDepth(TreeNode node, int depth) {
		if (node == null)
			return depth;
		else {
			int left = getDepth(node.left, depth+1);
			int right = getDepth(node.right, depth+1);
			return (left>right?left:right);
		}
	}
}
