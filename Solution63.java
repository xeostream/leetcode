/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class Solution63 {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int iLen = inorder.length;
		int pLen = postorder.length;
		if (iLen == 0 || pLen == 0 || iLen != pLen) return null;
		TreeNode root = buildTree(inorder, 0, iLen-1, postorder, 0, pLen-1);
		return root;
	}
	
	public TreeNode buildTree(int[] inorder, int ibegin, int iend, int[] postorder, int pbegin, int pend) {
		if (ibegin > iend || pbegin > pend) return null;
		TreeNode root = new TreeNode(postorder[pend]);
		int index = ibegin;
		for (; index <= iend; index++)
			if (inorder[index] == postorder[pend])
				break;
		root.right = buildTree(inorder, index+1, iend, postorder, pend-iend+index, pend-1);
		root.left = buildTree(inorder, ibegin, index-1, postorder, pbegin, pbegin+index-ibegin-1);
		return root;
	}
	public static void main(String ...args) {
		int[] inorder = {1,2};
		int[] postorder = {2,1};
		Solution63 s63 = new Solution63();
		TreeNode root = s63.buildTree(inorder, postorder);
		System.out.println(root.val+" "+ root.right.val);
	}
}
