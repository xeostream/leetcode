import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Clone Graph
 * Clone an undirected graph
 * Each node in the graph contains a label and a list of its neighbors
 */
public class Solution34 {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		UndirectedGraphNode head = null;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(node);
		while (queue.size() > 0) {
			head = new UndirectedGraphNode(queue.poll().label);
			for (UndirectedGraphNode n : head.neighbors)
				if (!map.containsKey(n.label))
					queue.offer(n);
			if (!map.containsKey(head.label))
				map.put(head.label, true);
		}
		return head;
	}
}
