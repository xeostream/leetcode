/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
		ListNode start = dummy, end = dummy;
		while (n-- > 0) {
			end = end.next;
		}
		while (end.next != null) {
			start = start.next;
			end = end.next;
		}
		start.next = start.next.next;
		return dummy.next;
    }
}