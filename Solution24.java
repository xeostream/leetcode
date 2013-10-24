/*
 * Merge Two Sorted Lists
 */
public class Solution24 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode head = new ListNode(0);
			ListNode n = head;
			while (l1 != null && l2 != null) {
				if (l1.val > l2.val) {
					n.next = l2;
					l2 = l2.next;
					n = n.next;
					continue;
				} else {
					n.next = l1;
					l1 = l1.next;
				}
				n = n.next;
			}
			n.next = (l1 == null) ? l2 : l1;
			return head.next;
		}
	}
	
	public static void main(String ...args) {
		Solution24 s24 = new Solution24();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = new ListNode(3);
		l1 = s24.mergeTwoLists(null, null);
		while (l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}
}
