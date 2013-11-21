/*
 * Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class Solution59 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	/*Runtime 572ms
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int diff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(diff) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int getHeight(TreeNode node) {
		if (node == null) return 0;
		int left = getHeight(node.left);
		int right = getHeight(node.right);
		return Math.max(left, right) + 1;
	}*/
	
	//Runtime 516ms
	public boolean isBalanced(TreeNode root) {
		int[] nums = new int[1];
		return isBalanced(root, nums);
	}
	
	public boolean isBalanced(TreeNode root, int[] nums) {
		if (root == null) {
			nums[0] = 0;
			return true;
		}
		int[] ld = new int[1], rd = new int[1];
		if (isBalanced(root.left, ld) && isBalanced(root.right, rd)){
			if (Math.abs(ld[0]-rd[0]) > 1)
				return false;
			nums[0] = Math.max(ld[0], rd[0]) + 1;
			return true;
		}
		return false;
	}
	
	public static void main(String ...args) {
		Solution59 s59 = new Solution59();
		TreeNode root = new TreeNode(1);
		//root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		
		System.out.println(s59.isBalanced(root));
	}
}
