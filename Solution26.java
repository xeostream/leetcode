/*
 * Swap Nodes in Pairs
 * Given 1->2->3->4, you should return the list as 2->1->4->3
 * should use only constant space
 * You may not modify the values in the list, only nodes itself can be changed
 */
public class Solution26 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
			}
	}
	
	public ListNode swapPairs(ListNode head) {
		if (head != null && head.next != null) {
			ListNode node = head;
			ListNode next = head.next;
			ListNode result = head.next;
			while (node != null && next != null) {
				ListNode pre = next.next;
				node.next = pre;
				next.next = node;
				node = pre;
				if (node == null)
					break;
				next = pre.next;
			}
			return result;
		}
		return head;
	}
	
	public static void main(String ...args) {
		Solution26 s26 = new Solution26();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = s26.swapPairs(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
