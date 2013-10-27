/*
 * Single Number II
 * Given an array of integers, every element appears three times except for one
 * Find that single one
 */
public class Solution30 {
	public int SingleNumber(int[] A) {
		int one = 0, two = 0;
		for (int i =0; i < A.length; i++) {
			int one_ = (one ^ A[i]) & (-1-two);
			int two_ = A[i] & one | (-1-A[i]) & two;
			one = one_;
			two = two_;
		}
		return one;
	}
	
	public static void main(String ...args) {
		int[] A = {1,1,1,2,3,3,3};
		Solution30 s30 = new Solution30();
		System.out.println(s30.SingleNumber(A));
	}
}
