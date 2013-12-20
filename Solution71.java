/*
 * Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class Solution71 {
	public int numTrees(int n) {
		return numTrees(1, n);
	}
	public int numTrees(int begin, int end) {
		if (begin >= end) return 1;
		int result = 0;
		for (int i = begin; i <= end; i++)
			result += numTrees(begin, i-1) * numTrees(i+1, end);
		return result;
	}
}
