/*
Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

public class Solution {
	public String strStr(String haystack, String needle) {
		if (haystack.length() >= needle.length()) {
			for (int i = 0; i < haystack.length()-needle.length(); i++) {
				String tmp = haystack.substring(i, i+needle.length());
				if (tmp.equals(needle)) {
					return haystack.substring(i);
				}
			}
			if (haystack.equals(needle)) {
				return needle;
			}
		}
		return null;
	}
}