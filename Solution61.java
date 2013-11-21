/*
 * Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution61 {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	/*Timeout
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		int mid = len / 2;
		int temp = mid;
		node = head;
		while (temp-- > 0)
			node = node.next;
		TreeNode root = new TreeNode(node.val);
		root.left = sortedListToBST(head, mid);
		root.right = sortedListToBST(node.next, len - mid - 1);
		return root;
	}
	
	public TreeNode sortedListToBST(ListNode head, int len) {
		if (len <= 0 || head == null) return null;
		int mid = len / 2;
		int temp = mid;
		ListNode node = head;
		while (temp-- > 0)
			node = node.next;
		TreeNode tn = new TreeNode(node.val);
		tn.left = sortedListToBST(head, mid);
		tn.right = sortedListToBST(node.next, len - mid - 1);
		return tn;
	}*/
	
	public TreeNode sortedListToBST(ListNode head) {
		ListNode node = head;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return sortedListToBST(head, len);
	}
	
	public TreeNode sortedListToBST(ListNode head, int len) {
		if (head == null || len == 0) return null;
		int mid = (len + 1) / 2;
		ListNode p = head;
		for (int i = 1; i < mid; i++)
			p = p.next;
		TreeNode root = new TreeNode(p.val);
		root.left = sortedListToBST(head, mid - 1);
		root.right = sortedListToBST(p.next, len - mid);
		return root;
	}
	
	public static void main(String ...args) {
		Solution61 s61 = new Solution61();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		TreeNode root = s61.sortedListToBST(head);
		System.out.println(root.val+" "+root.left.val+" "+root.right.val);
	}
}
