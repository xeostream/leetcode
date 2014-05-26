/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> rst = new ArrayList<String[]>();
		if (n == 1) {
		    String[] st = {"Q"};
		    rst.add(st);
		    return rst;
		}
		if (n < 4) return rst;
		String[] str = new String[n];
		solveNQueens(n, rst, str);
		return rst;
	}
	private void solveNQueens(int n, ArrayList<String[]> rst, String[] str) {
		if (n == 0) {
			String[] s = new String[str.length];
			System.arraycopy(str, 0, s, 0, str.length);
			rst.add(s);
			return ;
		}
		int[] index = new int[str.length+1-n];
		for (int i = 0; i < str.length-n; i++) {
			index[i] = str[i].indexOf("Q");
		}
		for (int i = 0; i < str.length; i++) {
			index[str.length-n] = i;
			if (nQueens(index)) {
				str[str.length-n] = initString(i, str.length);
				solveNQueens(n-1, rst, str);
			}
		}
	}
	private boolean nQueens(int[] index) {
		for (int i = 0; i < index.length; i++) {
			for (int j = i+1; j < index.length; j++) {
				if (index[i] == index[j]) return false;
				if (index[i]-index[j] == i-j) return false;
				if (index[i]-index[j] == j-i) return false;
			}
		}
		return true;
	}
	private String initString(int i, int n) {
		String s = "";
		for (int m = 0; m < i; m++) {
			s += ".";
		}
		s += "Q";
		for (int m = i+1; m < n; m++) {
			s += ".";
		}
		return s;
	}
}