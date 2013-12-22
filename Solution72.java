import java.util.ArrayList;

/*
 * Unique Binary Search Trees II
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 */
public class Solution72 {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	public ArrayList<TreeNode> generateTrees(int begin, int end) {
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		if (begin > end) {
			nodes.add(null);
			return nodes;
		}
		if (begin == end) {
			nodes.add(new TreeNode(begin));
			return nodes;
		}
		for (int i = begin; i <= end; i++) {
			ArrayList<TreeNode> left = generateTrees(begin, i - 1);
			ArrayList<TreeNode> right = generateTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					nodes.add(root);
				}
			}
		}
		return nodes;
	}
	/*
	public static void main(String ...args) {
		ArrayList<TreeNode> trees = Solution72.generateTrees(4);
		System.out.println(trees.size());
	}*/
}
