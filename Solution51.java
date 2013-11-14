/*
 * Populating Next Right Pointers in Each Node
 * NOTE: tree is perfect binary tree
 * Given the following perfect binary tree,
 *       1
 *     /  \
 *    2    3
 *   / \  / \
 *  4  5  6  7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \  / \
 *  4->5->6->7 -> NULL
 */

public class Solution51 {
	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {val = x;}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) return ;
		connect(root, null);
	}
	
	public void connect(TreeLinkNode cur, TreeLinkNode parent) {
		if (cur == null) return ;
		if (parent == null)
			cur.next = null;
		else if (cur == parent.left)
			cur.next = parent.right;
		else {
			if (parent.next == null)
				cur.next = null;
			else
				cur.next = parent.next.left;
		}
		connect(cur.left, cur);
		connect(cur.right, cur);
	}
}