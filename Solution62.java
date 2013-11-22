/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class Solution62 {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) { val = x; }
	}
	
	/*too low
	private HashMap<Integer, Integer> map;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) return null;
		TreeNode root = new TreeNode(preorder[0]);
		int len = inorder.length;
		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				if (inorder[j] == preorder[i]) {
					map.put(preorder[i], i);
					break;
				}
			}
		int index = -1;
		for (int i = 0; i < len; i++)
			if (inorder[i] == preorder[0]) {
				index = i;
				break;
			}
		root.left = buildTree(preorder, inorder, 0, index - 1);
		root.right = buildTree(preorder, inorder, index + 1, len - 1);
		return root;
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
		if (start > end) return null;
		if (start == end)
			return new TreeNode(inorder[start]);
		int index = 0;
		int value = preorder.length;
		for (int i = start; i <= end; i++)
			if (value > map.get(inorder[i])) {
				value = map.get(inorder[i]);
				index = i;
			}
		TreeNode root = new TreeNode(inorder[index]);
		root.left = buildTree(preorder, inorder, start, index - 1);
		root.right = buildTree(preorder, inorder, index + 1, end);
		return root;
	}*/
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	
    public TreeNode build(int[] pre, int start1, int end1, int[] in, int start2, int end2){
        if(start1 > end1 || start2 > end2) return null;
        int val = pre[start1];
        TreeNode cur = new TreeNode(val);
        int k = start2;
        for(; k <= end2; k++) 
            if(in[k] == val) break;
        cur.left = build(pre, start1 + 1, start1 + k - start2, in, start2, k - 1);
        cur.right = build(pre, start1 + k - start2 + 1, end1, in, k + 1, end2);
        return cur;
    }
	
	public static void main(String ...args) {
		int[] preorder = new int[3000];
		int[] inorder = new int[3000];
		for (int i = 0; i < 3000; i++) {
			preorder[i] = i - 999;
			inorder[i] = 2000 - i;
		}
		Solution62 s62 = new Solution62();
		TreeNode root = s62.buildTree(preorder, inorder);
		System.out.println(root.val+""+ root.left.val+""+preorder[2999]);
	}
}
