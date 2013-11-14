/*
 * Populating Next Right Pointers in Each Node II
 * NOTE: tree is only binary tree
 * Given the following binary tree,
 *       1
 *     /  \
 *    2    3
 *   / \    \
 *  4   5    7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \    \
 *  4-> 5 -> 7 -> NULL
 */
public class Solution52 {
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
		else if (cur == parent.left) {
			cur.next = parent.right;
			TreeLinkNode node = parent;
			setNext(cur, node);
		} else {
			TreeLinkNode node = parent;
			setNext(cur, node);
		}
		if (cur.next != null) {
			if (cur.next == parent.right)
				connect(cur.next, parent);
			else
				connect(cur.next, parent.next);
		}
		connect(cur.left, cur);
		connect(cur.right, cur);
	}
	
	public void setNext(TreeLinkNode cur, TreeLinkNode node) {
		while (cur.next == null && node.next != null) {
			if (cur != node.next.left)
				cur.next = node.next.left;
			if (cur.next != null) break;
			if (cur != node.next.right)
				cur.next = node.next.right;
			if (cur.next != null) break;
			node = node.next;
		}
	}
	
	public static void main(String ...args) {
		Solution52 s52 = new Solution52();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(6);
		root.left.left.left = new TreeLinkNode(7);
		root.right.right.right = new TreeLinkNode(8);
		s52.connect(root);
		System.out.println(root.left.right.next.val);
	}
}
