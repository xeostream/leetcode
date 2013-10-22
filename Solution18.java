/*
 * Single Number
 * algorithm should have a linear runtime complexity
 * without using extra memory is better
 */
public class Solution18 {
	public int singleNumber(int[] A) {
		for (int i = 1; i < A.length; i++)
			A[0] ^= A[i];
		return A[0];
	}
	
	public static void main(String ...args) {
		Solution18 s18 = new Solution18();
		int[] nums = {1,2,3,1,4,5,4,5,2};
		System.out.println(s18.singleNumber(nums));
	}
}
