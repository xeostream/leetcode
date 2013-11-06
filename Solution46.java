import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Preorder Traversal
 */
public class Solution46 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
		}
		return result;
	}
	
	public static void main(String ...args) {
		Solution46 s46 = new Solution46();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		ArrayList<Integer> result = s46.preorderTraversal(root);
		for (int i : result)
			System.out.print(i+" ");
		System.out.println();
	}
}
