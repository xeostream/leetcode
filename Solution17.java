import java.util.Stack;

/*
 * Maximal Rectangle
 */
public class Solution17 {
	public int MaximalRectangle(char[][] matrix) {
		int area = 0;
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int[][] heights = new int[m][n+1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0')
					heights[i][j] = 0;
				else
					heights[i][j] = i == 0 ? 1 : heights[i-1][j]+1;
			}
		}
		for (int i = 0; i < m; i++) {
			int temp = maxAreaInRow(heights[i]);
			if (temp > area)
				area = temp;
		}
		return area;
	}
	
	public int maxAreaInRow(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int area = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i])
				stack.push(i++);
			else {
				int t = stack.pop();
				area = Math.max(area, height[t]*(stack.isEmpty()?i:(i-stack.peek()-1)));
			}
		}
		return area;
	}
	
	public static void main(String ...args) {
		Solution17 s17 = new Solution17();
		char[][] matrix = {{'0','0','1','0'},{'0','0','0','1'},{'0','1','1','1'},{'0','0','1','1'}};
		System.out.println(s17.MaximalRectangle(matrix));
	}
}
