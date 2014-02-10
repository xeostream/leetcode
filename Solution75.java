/*
 * Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 */
public class Solution75 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (null == head || m == n) return head;
		ListNode start = new ListNode(-1);
		start.next = head;
		ListNode pre = start;
		
		for (int i = 1; i < m; i++)
			pre = pre.next;
		
		ListNode insertPre = pre.next;
		for (int i = m; i < n; i++) {
			ListNode cur = insertPre.next;
			insertPre.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
		}
		return start.next;
	}
}
