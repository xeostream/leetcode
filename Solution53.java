/*
 * Insertion Sort List
 * Sort a linked list using insertion sort.
 */
public class Solution53 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null)
			return head;
		ListNode res = new ListNode(Integer.MIN_VALUE);
		ListNode pre = res;
		ListNode cur = null;
		ListNode next;
		while (head != null) {
			next = head;
			head = head.next;
			next.next = null;
			pre = res;
			cur = pre.next;
			while (cur != null && cur.val < next.val) {
				cur = cur.next;
				pre = pre.next;
			}
			pre.next = next;
			next.next = cur;
		}
		return res.next;
	}
}
