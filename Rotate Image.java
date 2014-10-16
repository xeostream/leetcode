/*
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up: Could you do this in-place?
*/
/*
Solution:沿对角线对折，然后沿水平中线对折
*/

public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix.length < 2) return ;
		int len = matrix.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len-1-i; j++) {
				if (matrix[i][j] != matrix[len-1-j][len-1-i]) {
					matrix[i][j] = matrix[i][j] ^ matrix[len-1-j][len-1-i];
					matrix[len-1-j][len-1-i] = matrix[i][j] ^ matrix[len-1-j][len-1-i];
					matrix[i][j] = matrix[i][j] ^ matrix[len-1-j][len-1-i];
				}
			}
		}
		for (int i = 0; i < len/2; i++) {
			for (int j = 0; j < len; j++) {
				if (matrix[i][j] != matrix[len-1-i][j]) {
					matrix[i][j] = matrix[i][j] ^ matrix[len-1-i][j];
					matrix[len-1-i][j] = matrix[i][j] ^ matrix[len-1-i][j];
					matrix[i][j] = matrix[i][j] ^ matrix[len-1-i][j];
				}
			}
		}
	}
}