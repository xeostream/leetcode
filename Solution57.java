import java.util.ArrayList;
import java.util.Collections;

/*
 * Path Sum II
 * Given a binary tree and a sum
 * find all root-to-leaf paths where each path's sum equals the given sum.
 * Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \    / \
 *      7    2  5   1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 */
public class Solution57 {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	private ArrayList<ArrayList<Integer>> result;
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<ArrayList<Integer>>();
		if (root == null) return result;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(root.val);
		if (root.left == null && root.right == null && sum == root.val)
				result.add(temp);
		if (root.left != null)
			pathSum(root.left, sum-root.val, temp);
		if (root.right != null)
			pathSum(root.right, sum-root.val, temp);
		return result;
	}
	
	public void pathSum(TreeNode root, int sum, ArrayList<Integer> temp) {
		ArrayList<Integer> another = new ArrayList<Integer>();
		another.add(root.val);
		another.addAll(temp);
		if (root.left == null && root.right == null && sum == root.val) {
			Collections.reverse(another);
			result.add(another);
		}
		else {
			if (root.left != null)
				pathSum(root.left, sum-root.val, another);
			if (root.right != null)
				pathSum(root.right, sum-root.val, another);
		}			
	}
	
	public static void main(String ...args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(-2);
		root.left.left.left = new TreeNode(-1);
		Solution57 s57 = new Solution57();
		System.out.println(s57.pathSum(root, 2).size());
	}
}
