import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Postorder Traversal
 */
public class Solution47 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			Stack<TreeNode> temp = new Stack<TreeNode>();
			temp.push(root);
			while (!temp.isEmpty()) {
				TreeNode node = temp.pop();
				stack.push(node);
				if (node.left != null)
					temp.push(node.left);
				if (node.right != null)
					temp.push(node.right);
			}
			while (!stack.isEmpty())
				result.add(stack.pop().val);
		}
		return result;
	}
	public static void main(String ...args) {
		Solution47 s47 = new Solution47();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		ArrayList<Integer> result = s47.postorderTraversal(root);
		for (int i : result)
			System.out.print(i+" ");
		System.out.println();
	}
}
