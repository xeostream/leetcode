/*
 * Linked List Cycle II
 * Given a linked list, return the node where the cycle begins
 * If there is no cycle, return null
 */
public class Solution40 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
		if (head != null && head.next != null) {
			ListNode one = head.next;
			ListNode two = head.next.next;
			while (one != null && two != null && one != two) {
				one = one.next;
				if (two.next == null) return null;
				two = two.next.next;
			}
			if (one == two && one != null) {
				one = head;
				while (one != two) {
					one = one .next;
					two = two.next;
				}
				return one;
			}
		}
		return null;
	}
}
