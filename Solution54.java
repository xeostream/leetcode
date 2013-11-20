/*
 * Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Solution54 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode sortList(ListNode head) {
		if (head != null && head.next != null) {
			int len = 0;
			ListNode node = head;
			while (node != null) {
				len++;
				node = node.next;
			}
			int pivot = len / 2;
			int l1 = pivot, l2 = len - l1;
			node = head;
			while (--pivot > 0)
				node = node.next;
			ListNode n = node.next;
			ListNode start = new ListNode(Integer.MIN_VALUE);
			start.next = head;
			mergeSort(start, n, l1);
			while (node.next != n)
				node = node.next;
			mergeSort(node, null, l2);
			ListNode n1 = start.next, n2 = node.next;
			ListNode prev1 = start, prev2 = node;
			while (l1 > 0 && l2 > 0) {
				if (n1.val > n2.val) {
					ListNode temp = n2.next;
					prev1.next = n2;
					n2.next = n1;
					prev2.next = temp;
					n2 = temp;
					prev1 = prev1.next;
					l2--;
				} else {
					prev1 = n1;
					n1 = n1.next;
					l1--;
				}
			}
			return start.next;
		}
		return head;
	}
	
	public void mergeSort(ListNode start, ListNode end, int len) {
		if (len <= 1) return ;
		ListNode node = start.next;
		int i = len / 2;
		int l1 = i, l2 = len - l1;
		while (--i > 0)
			node = node.next;
		ListNode n = node.next;
		mergeSort(start, n, l1);
		while (node.next != n)
			node = node.next;
		mergeSort(node, end, l2);
		ListNode n1 = start.next, n2 = node.next;
		ListNode prev1 = start, prev2 = node;
		while (l1 > 0 && l2 > 0) {
			if (n1.val > n2.val) {
				ListNode temp = n2.next;
				prev1.next = n2;
				n2.next = n1;
				prev2.next = temp;
				n2 = temp;
				prev1 = prev1.next;
				l2--;
			} else {
				prev1 = n1;
				n1 = n1.next;
				l1--;
			}
		}
	}
	
	public static void main(String ...args) {
		Solution54 s54 = new Solution54();
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(1);
		//head.next.next.next = new ListNode(6);
		//head.next.next.next.next = new ListNode(1);
		head = s54.sortList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
