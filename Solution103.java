public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (null == obstacleGrid || obstacleGrid.length == 0) return 0;
		int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
		for (int i = 0; i < paths.length; i++) {
			for (int j = 0; j < paths[i].length; j++) {
				paths[i][j] = -1;
			}
		}
		return uniquePathsWithObstacles(obstacleGrid, paths, 0, 0);
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid, int[][] paths, int x, int y) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if (m == x || n == y || obstacleGrid[x][y] == 1) return 0;
		if (m == x+1 && n == y+1) return 1;
		if (paths[x][y] == -1) {
			paths[x][y] = uniquePathsWithObstacles(obstacleGrid, paths, x+1, y) + uniquePathsWithObstacles(obstacleGrid, paths, x, y+1);
		}
		return paths[x][y];
	}
}