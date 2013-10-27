/*
 * Copy List with Random Pointer
 */
public class Solution29 {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {label = x;}
	}
	
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
	}
}
