import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
		if (node == null) return null;
		UndirectedGraphNode head = null;
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<Integer> log = new HashSet<Integer>();
		queue.offer(node);
		while (queue.size() > 0) {
			UndirectedGraphNode temp = queue.poll();
			head = map.containsKey(temp.label) ? map.get(temp.label) : new UndirectedGraphNode(temp.label);
			for (UndirectedGraphNode n : temp.neighbors) {
				if (!map.containsKey(n.label)) {
					UndirectedGraphNode pre = new UndirectedGraphNode(n.label);
					map.put(n.label, pre);
				}
				if (!log.contains(n.label)) {
					queue.offer(n);
					log.add(n.label);
				}
				head.neighbors.add(map.get(n.label));
			}
			if (!map.containsKey(head.label))
				map.put(head.label, head);
		}
		return map.get(node.label);
	}
}
