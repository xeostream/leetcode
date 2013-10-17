import java.util.ArrayList;

/*
 * Binary Tree Level Order Traversal II
 */
public class Solution5 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {this.val = x;}
	}
	
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(root.val);
		if (root.left != null)
			nodeList.add(root.left);
		if (root.right != null)
			nodeList.add(root.right);
		levelOrder(result, nodeList);
		result.add(numbers);
		return result;
	}
	public void levelOrder(ArrayList<ArrayList<Integer>> result, ArrayList<TreeNode> temp) {
		if (temp.size() > 0) {
			ArrayList<TreeNode> t = new ArrayList<TreeNode>();
			ArrayList<Integer> data = new ArrayList<Integer>();
			for (TreeNode node : temp) {
				if (node.left != null)
					t.add(node.left);
				if (node.right != null)
					t.add(node.right);
				data.add(node.val);
			}
			levelOrder(result, t);
			result.add(data);
		}
	}
}
