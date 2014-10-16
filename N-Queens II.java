/*
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
	public int totalNQueens(int n) {
		if (n == 1) return 1;
		if (n < 4) return 0;
		int[] rst = new int[1];
		int[] record = new int[n];
		totalNQueens(n, rst, record);
		return rst[0];
	}
	private void totalNQueens(int n, int[] rst, int[] record) {
		if (n == 0) {
			rst[0]++;
			return ;
		}
		for (int i = 0; i < record.length; i++) {
			record[record.length-n] = i;
			if (nQueens(record, record.length+1-n)) {
				totalNQueens(n-1, rst, record);
			}
		}
	}
	private boolean nQueens(int[] index, int len) {
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if (index[i] == index[j]) return false;
				if (index[i]-index[j] == i-j) return false;
				if (index[i]-index[j] == j-i) return false;
			}
		}
		return true;
	}
}