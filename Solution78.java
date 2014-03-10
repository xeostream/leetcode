/*
 * Gray Code
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 */
public class Solution78 {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		if (n < 1) return result;
		int upper;
		for (int i = 1; i <= n; i++) {
			upper = (int) Math.pow(2, i-1);
			for (int j = result.size()-1; j >= 0; j--) {
				result.add(result.get(j) + upper);
			}
		}
		return result;
	}
}