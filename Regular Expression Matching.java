/*
Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
	public boolean isMatch(String s, String p) {
		if ("".equals(p))
			return "".equals(s);
		return isMatch(s, p, 0, 0);
	}
	private boolean isMatch(String s, String p, int sCur, int pCur) {
		if (pCur >= p.length())
			return sCur == s.length();
		if (pCur+1 >= p.length() || (pCur+1 < p.length()) && p.charAt(pCur+1) != '*') {
			if (sCur < s.length() && (s.charAt(sCur) == p.charAt(pCur) || p.charAt(pCur) == '.')) {
				return isMatch(s, p, sCur+1, pCur+1);
			} else {
				return false;
			}
		} else if (pCur+1 < p.length() && p.charAt(pCur+1) == '*') {
			while (sCur < s.length() && (s.charAt(sCur) == p.charAt(pCur) || p.charAt(pCur) == '.')) {
				if (isMatch(s, p, sCur, pCur+2))
					return true;
				sCur++;
			}
			return isMatch(s, p, sCur, pCur+2);
		} else {
			return false;
		}
	}
}