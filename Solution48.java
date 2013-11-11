import java.util.HashMap;

/*
 * LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class Solution48 {
	/*Time Limit Exceeded
	private int capacity;
	private HashMap<Integer, Integer> map;
	private HashMap<Integer, Integer> gets;
	public Solution48(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Integer>();
		gets = new HashMap<Integer, Integer>();
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			int temp = gets.get(key);
			gets.remove(key);
			gets.put(key, ++temp);
			return map.get(key);
		}
		return -1;
	}
	
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
		} else {
			if (capacity > 0) {
				map.put(key, value);
				gets.put(key, 0);
				capacity--;
			} else {
				int min = 0;
				int k = 0;
				Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator() ;
				while (iter.hasNext()) {
					Map.Entry<Integer, Integer> entry = iter.next();
					k = (min > entry.getValue() ? entry.getKey() : k);
					min = (min > entry.getValue() ? entry.getValue() : min);
				}
				map.remove(k);
				gets.remove(k);
				map.put(key, value);
				gets.put(key, 0);
			}
		}
	}*/
	static class Node {
		int key;
		int value;
		Node prev;
		Node next;
		Node() {
			key = value = 0;
		}
		Node(int k, int v) {
			key = k;
			value = v;
		}
	}
	
	private HashMap<Integer, Node> map;
	private int capacity;
	private Node head;
	private Node tail;
	public Solution48(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node();
		tail = new Node();
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		tail.next = null;
	}
	
	public void set(int key, int value) {
		Node node;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			detach(node);
			attach(node);
		}
		else {
			if (map.size() == capacity) {
				node = tail.prev;
				detach(node);
				map.remove(node.key);
			}
			node = new Node(key, value);
			attach(node);
			map.put(key, node);
		}
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			detach(node);
			attach(node);
			return node.value;
		}
		return -1;
	}
	
	private void detach(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	private void attach(Node node) {
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
		node.prev = head;
	}
	
	public static void main(String ...args) {
		Solution48 s48 = new Solution48(2);
		s48.set(1, 9);
		s48.set(0, 10);
		s48.get(1);
		s48.get(1);
		s48.get(0);
		s48.set(2, 8);
		System.out.println(s48.get(0));
		System.out.println(s48.get(1));
		System.out.println(s48.get(2));
	}
}
