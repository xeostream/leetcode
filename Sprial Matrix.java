/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = n-1, top = 0, bottom = m-1;
		if (left == right) {
			for (int[] list : matrix) {
				rst.add(list[0]);
			}
			return rst;
		}
		/*if (top == bottom) {
			for (int i : matrix[0]) {
				rst.add(i);
			}
			return rst;
		}*/
		int x = 0, y = 0;
		while (true) {
			if (matrix[x][y] == Integer.MIN_VALUE) break;
			rst.add(matrix[x][y]);
			if (x == top && y != right) {
				matrix[x][y++] = Integer.MIN_VALUE;
			} else if (x != bottom && y == right) {
				matrix[x++][y] = Integer.MIN_VALUE;
			} else if (x == bottom && y != left) {
				matrix[x][y--] = Integer.MIN_VALUE;
			} else if (x != top+1 && y == left) {
				matrix[x--][y] = Integer.MIN_VALUE;
			}else if (x == top+1 && y == left) {
				matrix[x][y++] = Integer.MIN_VALUE;
				left++;
				right--;
				top++;
				bottom--;
			}
		}
		return rst;
	}
}