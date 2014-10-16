/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules
http://sudoku.com.au/TheRules.aspx .
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean[] used = new boolean[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!isValid(board[i][j], used)) {
					return false;
				}
			}
			initUsed(used);
			for (int j = 0; j < 9; j++) {
				if (!isValid(board[j][i], used)) {
					return false;
				}
			}
			initUsed(used);
			for (int m = (i%3)*3; m < (i%3+1)*3; m++) {
				for (int n = (i/3)*3; n < (i/3+1)*3; n++) {
					if (!isValid(board[m][n], used)) {
						return false;
					}
				}
			}
			initUsed(used);
		}
		return true;
	}
	private boolean isValid(char c, boolean[] used) {
		if (c == '.') {
			return true;
		} else if (used[c-'1']) {
			return false;
		} else {
			return used[c-'1'] = true;
		}
	}
	private void initUsed(boolean[] used) {
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}
	}
}