/*
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
	public String intToRoman(int num) {
		String rst = "";
		int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		for (int i = 0; i < radix.length; i++) {
			int cnt = num / radix[i];
			num %= radix[i];
			for (; cnt > 0; cnt--) {
				rst += symbol[i];
			}
		}
		return rst;
	}
}