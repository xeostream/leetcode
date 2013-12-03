import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *	[3],
 *	[20,9],
 *	[15,7]
 * ]
 */
public class Solution68 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) return result;
		Queue<TreeNode> parent = new LinkedList<TreeNode>();
		Queue<TreeNode> sons = new LinkedList<TreeNode>();
		parent.offer(root);
		while (!parent.isEmpty()) {
			ArrayList<Integer> record = new ArrayList<Integer>();
			while (!parent.isEmpty()) {
				TreeNode temp = parent.poll();
				record.add(temp.val);
				if (temp.left != null)
					sons.offer(temp.left);
				if (temp.right != null)
					sons.offer(temp.right);
			}
			result.add(record);
			Queue<TreeNode> q = parent;
			parent = sons;
			sons = q;
		}
		for (int i = 0; i < result.size(); i++)
			if (i % 2 == 1)
				Collections.reverse(result.get(i));
		return result;
	}
	public static void main(String ...args) {
		Solution68 s68 = new Solution68();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		ArrayList<ArrayList<Integer>> result = s68.zigzagLevelOrder(root);
		for (ArrayList<Integer> list : result) {
			for (int i : list)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
