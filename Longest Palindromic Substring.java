/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S 
is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
	public String longestPalindrome(String s) {
		boolean[][] matrix = new boolean[s.length()][s.length()];
		int maxLen = 1, start = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {
				matrix[i][i] = true;
				matrix[j][i] = s.charAt(j) == s.charAt(i) && ((i - j) < 2 || matrix[j+1][i-1]);
				if (matrix[j][i] && (maxLen < (i - j + 1))) {
					maxLen = i - j + 1;
					start = j;
				}
			}
		}
		return s.substring(start, start + maxLen);
	}
}