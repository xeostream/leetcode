/*
 * Surrounded Regions
 * A region is captured by flipping all 'O's into 'X's in that surrounded region
 */
public class Solution20 {
	/* wrong method
	public void solve(char[][] board) {
		if (board == null || board.length < 3 || board[0].length < 3)
			return ;
		for (int i = 1; i < board.length-1; i++) {
			for (int j = 1; j < board[i].length-1; j++) {
				if (board[i][j] == 'o') {
					int row = i, col = j;
					int cnt = 0;
					while (row >= 0) {
						if (board[row][j] == 'x') {
							cnt++;
							break;
						}
						row--;
					}
					if (cnt != 1) break;
					row = i;
					while (row < board.length) {
						if (board[row][j] == 'x') {
							cnt++;
							break;
						}
						row++;
					}
					if (cnt != 2) break;
					while (col >= 0) {
						if (board[i][col] == 'x') {
							cnt++;
							break;
						}
						col--;
					}
					if (cnt != 3) break;
					col = j;
					while (col < board[i].length) {
						if (board[i][col] == 'x') {
							cnt++;
							break;
						}
						col++;
					}
					if (cnt == 4)
						board[i][j] = 'x';
				}
			}
		}
	}*/
	/* last test case runtime error
	public void solve(char[][] board) {
		if (board.length == 0 || (board.length < 3 && board[0].length < 3))
			return ;
		boolean[][] isChange = new boolean[board.length][board[0].length];
		for (int i = 0; i < board[0].length; i++) {
			change(board, isChange, 0, i);
			change(board, isChange, board.length-1, i);
		}
		for (int i = 0; i < board.length; i++) {
			change(board, isChange, i, 0);
			change(board, isChange, i, board[i].length-1);
		}
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'o')
					board[i][j] = 'x';
				else if (board[i][j] == '#')
					board[i][j] = 'o';
			}
	}
	
	public void change(char[][] board, boolean[][]isChange, int row, int col) {
		if (row < 0 || row >= board.length ||col < 0 || col >= board[row].length || isChange[row][col])
			return ;
		isChange[row][col] = true;
		if (board[row][col] == 'o') {
			board[row][col] = '#';
			change(board, isChange, row-1, col);
			change(board, isChange, row+1, col);
			change(board, isChange, row, col-1);
			change(board, isChange, row, col+1);
		}
	}*/
	// copy from https://github.com/mengli/leetcode/blob/master/Surrounded%20Regions.java, thanks for mengli
	public class Point {
            public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    	public void solve(char[][] board) {
        	int height = board.length;
        	int width = 0;
        	if (height > 0) {
            		width = board[0].length;
        	}
                
        	Queue<Point> q = new LinkedList<Point>();
        	for (int i = 0; i < width; i++) {
            		for (int j = 0; j < height; j++) {
                		if ((i == 0 || i == width - 1 || j == 0 || j == height - 1) && board[i][j] == 'O') {
                    			q.add(new Point(i, j));
                		}
            		}
        	}
                
        	while (q.peek() != null) {
           		Point p = q.remove();
           		board[p.x][p.y] = '-';
            		if (p.x > 0 && board[p.x - 1][p.y] == 'O') {
                	q.add(new Point(p.x - 1, p.y));
            		}
            		if (p.x < width - 1 && board[p.x + 1][p.y] == 'O') {
                		q.add(new Point(p.x + 1, p.y));
            		}
            		if (p.y > 0 && board[p.x][p.y - 1] == 'O') {
                		q.add(new Point(p.x, p.y - 1));
            		}
            		if (p.y < height - 1 && board[p.x][p.y + 1] == 'O') {
                		q.add(new Point(p.x, p.y + 1));
            		}
        	}
                
        	for (int i = 0; i < width; i++) {
            		for (int j = 0; j < height; j++) {
                		if (board[i][j] != 'X')
                   			board[i][j] = board[i][j] == 'O' ? 'X' : 'O';
            		}
        	}
    	}
	
	public static void main(String ...args) {
		Solution20 s20  = new Solution20();
		char[][] board = {"xxx".toCharArray(),"xox".toCharArray(),"xxx".toCharArray()};
		s20.solve(board);
		for (char[] b : board) {
			for (char bo : b) {
				System.out.print(bo+ " ");
			}
			System.out.println();
		}
	}
}
