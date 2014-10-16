/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		return longestCommonPrefix(strs, 0, strs.length-1);

	}
	private String longestCommonPrefix(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		} else if (start == end-1) {
			return longestCommonPrefix(strs[start], strs[end]);
		} else {
			int mid = (start + end) / 2;
			return longestCommonPrefix(longestCommonPrefix(strs, start, mid), longestCommonPrefix(strs, mid+1, end));
		}
	}
	private String longestCommonPrefix(String str1, String str2) {
		int i= 0
		for (; i < str1.length() && i < str2.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return str1.substring(0, i);
			}
		}
		return str1.substring(0, i);
	}
}