/*
 * Copy List with Random Pointer
 */
public class Solution29 {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {label = x;}
	}
	/* {-1,#} runtime error
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode current = head;
		while (current != null) {
			RandomListNode temp = current.next;
			current.next = new RandomListNode(current.label);
			current.next.next = temp;
			current = temp;
		}
		RandomListNode rand = head;
		while (rand != null) {
			if (rand.random != null)
				rand.next.random = rand.random.next;
			rand = rand.next.next;
		}
		RandomListNode cur = head;
		RandomListNode node = cur.next;
		RandomListNode result = node;
		while (cur.next.next != null) {
			cur.next = cur.next.next;
			result.next = result.next.next;
			cur = cur.next;
			result = result.next;
		}
		return node;
	}*/
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode cur = head;
        while (cur != null) {
                RandomListNode newNode = new RandomListNode(cur.label);
                newNode.next = cur.next;
                cur.next = newNode;
                cur = newNode.next;
        }
        cur = head;
        while (cur != null) {
                if (cur.random != null) {
                        cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
        }
        cur = head.next;
        RandomListNode newHead = cur;
        RandomListNode old = head;
        while (old != null) {
                old.next = old.next.next;
                if (old.next != null) {
                        cur.next = old.next.next;
                }
                cur = cur.next;
                old = old.next;
        }
        return newHead;
}
}
