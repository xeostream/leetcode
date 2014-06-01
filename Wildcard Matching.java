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
		int i = 0, j = 0;
		int star_s = Integer.MIN_VALUE, star_p = Integer.MIN_VALUE;
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				while (j < p.length() && p.charAt(j) == '*')
					j++;
				if (j == p.length())
					return true;
				star_p = j;
				star_s = i;
			} else if (star_p != Integer.MIN_VALUE && (j < p.length() || i < s.length())) {
				i = ++star_s;
				j = star_p;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*')
			j++;
		return j == p.length();
	}
}