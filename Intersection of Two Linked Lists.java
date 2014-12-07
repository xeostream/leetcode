/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
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