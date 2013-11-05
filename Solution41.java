/*
 * Binary Tree Maximum Path Sum
 * Given a binary tree, find the maximum path sum
 * The path may start and end at any node in the tree
 */
public class Solution41 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max[] = new int[1]; // this is used to keep max val
        max[0] = Integer.MIN_VALUE;
        localSum(root, max);
        return max[0];       
    }
     
    public int localSum(TreeNode root, int[] max) {
        if (root == null) return 0;
        int lsum = localSum(root.left, max);
        int rsum = localSum(root.right, max);
        int csum = Math.max(root.val, Math.max(root.val + lsum, root.val + rsum));
         
        max[0] = Math.max(max[0], Math.max(csum, lsum + root.val + rsum));
        return csum;
    }
	
	public static void main(String ...args) {
		Solution41 s41 = new Solution41();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(s41.maxPathSum(root));
	}
}
