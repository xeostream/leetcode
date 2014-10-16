/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Solution {
	public boolean canJump(int[] A) {
		if (A.length < 2 || A[0] >= A.length) return true;
		boolean[] pro = new boolean[A.length];
		pro[A.length-1] = true;
		for (int i = A.length-2; i >= 0; i--) {
			for (int j = 1; j <= A[i]; j++) {
				if (pro[i+j]) {
					pro[i] = true;
					break;
				} else {
					j = (A[i+j] > j ? A[i+j] : j);
				}
			}
		}
		return pro[0];
	}
}