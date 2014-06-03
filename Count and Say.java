/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
	public String countAndSay(int n) {
		String rst = "1";
		for (int i = 1; i < n; i++) {
			rst += "*";
			String tmp = "";
			int cnt = 1;
			char c = rst.charAt(0);
			for (int j = 1; j < rst.length(); j++) {
				if (c != rst.charAt(j)) {
					tmp += (cnt + "" + c);
					cnt = 1;
					c = rst.charAt(j);
				} else {
					cnt++;
				}
			}
			rst = new String(tmp);
		}
		return rst;
	}
}