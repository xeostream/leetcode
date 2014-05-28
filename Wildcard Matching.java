/*
Implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character. '*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class Solution {
	public boolean isMatch(String s, String p) {
		if (s.length() != p.length() && p.indexOf("*") < 0) return false;
		int i = 0, j = 0;
		while (i < s.length() && j < p.length()) {
			if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
				i++;
				j++;
			} else if (p.charAt(j) == '*') {
				while (j < p.length() && p.charAt(j) == '*') {
					j++;
				}
				if (j == p.length()) return true;
				while (i < s.length() && s.charAt(i) != p.charAt(j)) {
					i++;
				}
				if (i == s.length()) return false;
			} else {
				return false;
			}
		}
		if (i == s.length() && j == p.length()) {
			return true;
		} else {
			return false;
		}
	}
}