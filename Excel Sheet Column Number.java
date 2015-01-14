/*
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class Solution {
	public int titleToNumber(String s) {
		int number = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(len - i - 1);
			number += (c - 'A' + 1) * Math.pow(26, i);
		}
		return number;
	}
}