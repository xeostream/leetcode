/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
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
public class Solution81 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        boolean needPartition = true;
        while (needPartition) {
        	ListNode node = head;
        	needPartition = false;
        	while (node.next != null) {
        		if (node.val >= x && node.next.val < x) {
        			node.val = node.val ^ node.next.val;
        			node.next.val = node.val ^ node.next.val;
        			node.val = node.val ^ node.next.val;
        			needPartition = true;
        		}
        		node = node.next;
        	}
        }
        return head;
    }
}