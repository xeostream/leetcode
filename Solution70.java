/*
 * Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 */
public class Solution70 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	private TreeNode prev;
	private TreeNode itema, itemb;
	public void recoverTree(TreeNode root) {
		prev = itema = itemb = null;
		traverse(root);
		if (itema != null && itemb == null)
			itemb = prev;
		if (itema != null && itemb != null) {
			int temp = itema.val;
			itema.val = itemb.val;
			itemb.val = temp;
		}
	}
	private void traverse(TreeNode root) {
		if (root == null) return ;
		traverse(root.left);
		if (prev != null) {
			if (itema != null && root.val > itema.val)
				itemb = prev;
			if (itema == null && prev.val > root.val)
				itema = prev;
			if (itema != null && itemb != null)
				return ;
		}
		prev = root;
		traverse(root.right);
	}
	public static void main(String ...args) {
		Solution70 s70 = new Solution70();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(5);
		root.left.right.left.right = new TreeNode(4);
		s70.recoverTree(root);
		System.out.println(root.val);
		System.out.println(root.left.right.val);
	}
}
