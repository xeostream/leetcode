/*
 * Reorder List
 * Given a singly linked list L: L0��L1������Ln-1��Ln
 * reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
 */
public class Solution42 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return ;
		ListNode node = null;
		ListNode next = head.next;
		ListNode cur = new ListNode(head.val);
		ListNode curNode = cur;
		while (next != null) {
			cur.next = new ListNode(next.val);
			cur = cur.next;
			next = next.next;
		}
		while (curNode != null) {
			ListNode temp = curNode.next;
			curNode.next = node;
			node = curNode;
			curNode = temp;
		}
		cur = head;
		while (cur != node && cur.next != node) {
			ListNode temp1 = cur.next;
			ListNode temp2 = node.next;
			cur.next = node;
			node.next = temp1;
			cur = temp1;
			node = temp2;
		}
		if (cur.val == node.val)
			cur.next = null;
		else {
			cur.next = node;
			cur.next.next = null;
		}
	}
	
	public static void main(String ...args) {
		Solution42 s42 = new Solution42();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		s42.reorderList(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
