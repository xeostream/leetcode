/*
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
*/
public class Solution {
	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) return "0";
		int len1 = num1.length(), len2 = num2.length();
		int[] tmp = new int[len1+len2];
		for (int i = len2-1; i >= 0; i--) {
			int i1 = num2.charAt(i) - '0';
			for (int j = len1-1; j >= 0; j--) {
				int j1 = num1.charAt(j) - '0';
				int multi = i1 * j1;
				tmp[i+j+1] += multi;
				for (int m = i+j+1; m >= 0; m--) {
					if (tmp[m] > 9) {
						int div = tmp[m] / 10;
						tmp[m] %= 10;
						tmp[m-1] += div;
					} else {
						break;
					}
				}
			}
		}
		int end = 0;
		while (tmp[end] == 0) {
			end++;
		}
		String rst = "";
		for (int i = end; i < len1+len2; i++) {
			rst += ("" + tmp[i]);
		}
		return rst;
	}
}