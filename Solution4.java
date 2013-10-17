/*
 * Rotate List
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class Solution4 {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n == 0)
			return head;
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}
		int[] numbers = new int[length];
		node = head;
		int index = 0;
		while (node != null) {
			numbers[index++] = node.val;
			node = node.next;
		}
		swap(numbers, 0, length-(n%length)-1);
		swap(numbers, length-(n%length), length-1);
		swap(numbers, 0, length-1);
		node = head;
		for (int i : numbers) {
			node.val = i;
			node = node.next;
		}
		return head;
	}
	
	public void swap(int[] numbers, int begin, int end) {
		int i = begin;
		int j = end;
		while (i < j) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
			i++;
			j--;
		}
	}
	public static void main(String... args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l1 = new Solution4().rotateRight(l1, 1);
		while (l1 != null) {
			System.out.print(l1.val + " ");
			l1 = l1.next;
		}
	}
}
