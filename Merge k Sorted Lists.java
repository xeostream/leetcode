/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
        	return null;
        }
        return divide(lists, 0, lists.size()-1);
    }
    private ListNode divide(List<ListNode> lists, int left, int right) {
    	if (left < right) {
    		int mid = (left + right) / 2;
    		return merge2Lists(divide(lists, left, mid), divide(lists, mid+1, right));
    	}
    	return lists.get(left);
    }
    private ListNode merge2Lists(ListNode head, ListNode node) {
    	ListNode mList = new ListNode(-1);
    	for (ListNode p = mList; head != null || node != null; p = p.next) {
    		int val1 = head == null ? Integer.MAX_VALUE : head.val;
    		int val2 = node == null ? Integer.MAX_VALUE : node.val;
    		if (val1 < val2) {
    			p.next = head;
    			head = head.next;
    		} else {
    			p.next = node;
    			node = node.next;
    		}
    	}
    	return mList.next;
    }
}