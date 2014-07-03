/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dump = new ListNode(Integer.MIN_VALUE);
		ListNode node = dump;
		int tmp = 0;
		while (l1 != null && l2 != null) {
			int add = (l1.val + l2.val + tmp) % 10;
			tmp = (l1.val + l2.val + tmp) / 10;
			l1.val = add;
			node.next = l1;
			l1 = l1.next;
			l2 = l2.next;
			node = node.next;
		}
		if (l1 == null && l2 != null) {
			addTwoNumbers(node, l2, tmp);
		} else if (l1 != null && l2 == null) {
			addTwoNumbers(node, l1, tmp);
		} else {
			if (tmp > 0) {
				node.next = new ListNode(tmp);
			}
		}
		return dump.next;
	}
	private void addTwoNumbers(ListNode node, ListNode l, int tmp) {
		while (l != null) {
			int add = (l.val + tmp) % 10;
			tmp = (l.val + tmp) / 10;
			l.val = add;
			node.next  = l;
			l = l.next;
			node = node.next;
		}
		if (tmp > 0) {
			node.next  = new ListNode(tmp);
		}
	}
}