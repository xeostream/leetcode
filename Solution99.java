/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
	public int[] plusOne(int[] digits) {
		int[] ret = new int[digits.length+1];
		digits[digits.length-1] = digits[digits.length-1] + 1;
		for (int i = digits.length-1; i > 0; i--) {
			digits[i-1] += digits[i] / 10;
			ret[i+1] = digits[i] % 10;
		}
		ret[0] = digits[0] / 10;
		ret[1] = digits[0] % 10;
		if (ret[0] == 0) {
			System.arrayCopy(ret, 1, digits, 0, digits.length);
			return digits;
		} else {
			return ret;
		}
	}
}