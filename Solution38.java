/*
 * Linked List Cycle
 */
public class Solution38 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head != null && head.next != null) {
			ListNode one = head.next;
			ListNode two = head.next.next;
			while (one != two) {
				if (one == null || two == null || two.next == null)
					return false;
				one = one.next;
				two = two.next.next;
			}
			return true;
		}
		return false;
	}
}
