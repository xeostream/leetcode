/*Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character*/
public class Solution {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int[][] step = new int[len1+1][len2+1];
		for (int i = 0; i <= len1; i++) {
			step[i][0] = i;
		}
		for (int j = 1; j <= len2; j++) {
			step[0][j+1] = j;
		}
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				int delta = (word1.charAt(i)==word2.charAt(j)) ? 0 : 1;
				step[i+1][j+1] = min(step[i][j+1]+1, step[i+1][j]+1, step[i][j]+delta);
			}
		}
		return step[len1][len2];
	}
	public int min(int a, int b, int c) {
		int d = Math.min(a, b);
		return Math.min(d, c);
	}
}