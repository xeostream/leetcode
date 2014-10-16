/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
*/

public class Solution {
	public void solveSudoku(char[][] board) {
		sudokuSolution(board);
	}
	private boolean sudokuSolution(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int m = 0; m < 9; m++) {
						board[i][j] = (char) '1' + m;
						if (isValid(board, i, j) && sudokuSolution(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}
	private boolean isValid(char[][] board, int i, int j) {
		for (int m = 0; m < 9; m++) {
			if (board[i][m] == board[i][j] && m != j) {
				return false;
			}
		}
		for (int m = 0; m < 9; m++) {
			if (board[m][j] == board[i][j] && m != i) {
				return false;
			}
		}
		for (int m = i-i%3; m < (i/3+1)*3; m++) {
			for (int n = j-j%3; n < (j/3+1)*3; n++) {
				if (board[m][n] == board[i][j] && m != i && n != j) {
					return false;
				}
			}
		}
		return true;
	}
}