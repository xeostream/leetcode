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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        ListNode node = headB;
        while (null != node.next) {
        	node = node.next;
        }
        node.next = headA;
        node = headB.next.next;
        headA = headB.next;
        while (node != headA) {
        	if (null == node || null == node.next || null == node.next.next) {
        		break;
        	}
        	node = node.next.next;
        	headA = headA.next;
        }
        if (node == headA) {
        	while (headA != headB) {
        		headB = headB.next;
        		headA = headA.next;
        	}
        	return headA;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int lenA = length(headA), lenB = length(headB);
    	while (lenA > lenB) {
    		headA = headA.next;
    		lenA--;
    	}
    	while (lenA < lenB) {
    		headB = headB.next;
    		lenB--;
    	}
    	while (headA != headB) {
    		headA = headA.next;
    		headB = headB.next;
    	}
    	return headA;
    }

    private int length(ListNode node) {
    	int length = 0;
    	while (null != node) {
    		node = node.next;
    		length++;
    	}
    	return length;
    }
}