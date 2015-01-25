/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

	private int cur;

	private List<Integer> numbers;

    public BSTIterator(TreeNode root) {
        this.cur = 0;
        this.numbers = new ArrayList<Integer>();
        init(numbers, root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur < numbers.size();
    }

    /** @return the next smallest number */
    public int next() {
        return numbers.get(cur++);
    }

    private void init(List<Integer> numbers, TreeNode root) {
    	if (null == root) return ;
    	init(numbers, root.left);
    	numbers.add(root.val);
    	init(numbers, root.right);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */