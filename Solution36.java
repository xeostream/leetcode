/*
 * Sum Root to Leaf Numbers
 */

/**
 *
 * @author Arthur
 */
public class Solution36 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root != null) {
	    if (root.left == null && root.right == null) return root.val;
            String s = "" + root.val;
            sum = strToNumber(s, root.left) + strToNumber(s, root.right);
        }
        return sum;
    }
    
    public int strToNumber(String s, TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return Integer.parseInt(s+node.val);
        else if (node.left == null)
            return strToNumber(s+node.val, node.right);
        else if (node.right == null)
            return strToNumber(s+node.val, node.left);
        else
            return strToNumber(s+node.val, node.left) + strToNumber(s+node.val, node.right);
    }
    
    public static void main(String ...args) {
        Solution36 s36 = new Solution36();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(s36.sumNumbers(root));
    }
}
