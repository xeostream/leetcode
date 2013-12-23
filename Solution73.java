import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class Solution73 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> record = new Stack<TreeNode>();
			record.push(root);
			TreeNode temp = root.left;
			while (temp != null || !record.isEmpty()) {
				while (temp != null) {
					record.push(temp);
					temp = temp.left;
				}
				if (!record.isEmpty()) {
					temp = record.pop();
					result.add(temp.val);
					temp = temp.right;
				}
			}
		}
		return result;
	}
	public static void main(String ...args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		ArrayList<Integer> result = Solution73.inorderTraversal(root);
		for (int i : result)
			System.out.print(i);
		System.out.println();
	}
}
