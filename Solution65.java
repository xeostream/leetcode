import java.util.Stack;

/*
 * Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * this binary tree is symmetric:
 * 	    1
 *     / \
 *	  2   2
 *	 / \ / \
 *	3  4 4  3
 * the following is not:
 *     1
 *	  / \
 *   2   2
 *    \   \
 *    3    3
 */
public class Solution65 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	/*recursively
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		else if (left == null || right == null) return false;
		else if (left.val != right.val) return false;
		else
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}*/
	
	//iteratively
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		Stack<TreeNode> left = new Stack<TreeNode>();
		Stack<TreeNode> right = new Stack<TreeNode>();
		left.push(root.left);
		right.push(root.right);
		while (!left.isEmpty() && !right.isEmpty()) {
			TreeNode ln = left.pop();
			TreeNode rn = right.pop();
			if (ln == null && rn == null) continue;
			else if (ln == null || rn == null || ln.val != rn.val) return false;
			left.push(ln.left);
			left.push(ln.right);
			right.push(rn.right);
			right.push(rn.left);
		}
		return (left.isEmpty() && right.isEmpty()) ? true : false;
	}
}
