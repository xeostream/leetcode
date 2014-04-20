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
public class Solution84 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                    map.put(node.val, true);
                    node.next = node.next.next;
            }
            node = node.next;
        }
        node = new ListNode(Integer.MIN_VALUE);
        node.next = head;
        ListNode cur = head, pre = node;
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                    pre.next = cur.next;
            } else {
                    pre = cur;
            }
            cur = cur.next;
        }
        return node.next;
    }
}