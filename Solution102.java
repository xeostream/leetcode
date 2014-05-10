public class Solution {
	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				paths[i][j] = -1;
			}
		}
		return uniquePaths(m, n, 0, 0, paths);
	}
	public int uniquePaths(int m, int n, int x, int y, int[][] paths) {
		if (m == x+1 && n == y+1) return 1;
		if (m == x || n == y) return 0;
		if (paths[x][y] == -1) {
			paths[x][y] = uniquePaths(m, n, x+1, y, paths) + uniquePaths(m, n, x, y+1, paths);
		}
		return paths[x][y];
	}
}