/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
	public int[][] geneareteMatrix(int n) {
		if (n < 1) return null;
		int[][] matrix = new int[n][n];
		int left = 0, right = n-1, top = 0, bottom = n-1;
		int x = 0, y = 0, val = 1;
		while (true) {
			if (matrix[x][y] != 0) break;
			if (x == top && y != right) {
				matrix[x][y++] = val++;
			} else if (x != bottom && y == right) {
				matrix[x++][y] = val++;
			} else if (x == bottom && y != left) {
				matrix[x][y--] = val++;
			} else if (x != top+1 && y == left) {
				matrix[x--][y] = val++;
			}else if (x == top+1 && y == left) {
				left++;
				right--;
				top++;
				bottom--;
			}
		}
		return matrix;
	}
}