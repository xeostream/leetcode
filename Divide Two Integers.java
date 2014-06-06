/*
Divide two integers without using multiplication, division and mod operator.
*/

public class Solution {
	public int divide(int dividend, int divisor) {
		int rst = 0;
		boolean sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		long a = dividend;
		long b = divisor;
		a = Math.abs(a);
		b = Math.abs(b);
		while (a >= b) {
			long c = b;
			for (int i = 0; a >= c; i++, c <<= 1) {
				a -= c;
				rst += (1 << i);
			}
		}
		return sign ? -rst : rst;
	}
}