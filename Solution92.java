/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int len = matrix.length;
		int max = matrix[len-1][matrix[len-1].length-1], min = matrix[0][0];
		if (target > max || target < min) return false;
		int pivot = matrix[len-1][0];
		if (pivot == target) return true;
		else if (pivot > target) return searchMatrix(matrix, target, len-2);
		else return searchMatrix(matrix[len-1], target);
	}
	public boolean searchMatrix(int[][] matrix, int target, int row) {
		int max = matrix[row][matrix[row].length-1];
		if (target > max) return false;
		int pivot = matrix[row][0];
		if (pivot == target) return true;
		else if (pivot > target) return searchMatrix(matrix, target, row-1);
		else return searchMatrix(matrix[row], target);
	}
	public boolean searchMatrix(int[] list, int target) {
		for (int i : list) {
				if (i == target) return true;
				if (i > target) return false;
			}
		return false;
	}
}