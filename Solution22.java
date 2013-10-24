/*
 * Remove Duplicates from Sorted List
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution22 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null && node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
				continue;
			}
			node = node.next;
		}
		return head;
	}
	
	public static void main(String ...args) {
		Solution22 s22 = new Solution22();
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(1);
		ListNode no = new ListNode(1);
		ListNode n = new ListNode(2);
		head.next = node;
		node.next = no;
		no.next = n;
		head = s22.deleteDuplicates(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
