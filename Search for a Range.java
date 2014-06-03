/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
	public int[] searchRange(int[] A, int target) {
		int[] rst = {-1, -1};
		int index = binarySearch(A, 0, A.length-1, target);
		if (index == -1) {
			return rst;
		}
		rst = {index, index};
		for (int i = index; i >= 0; i--) {
			if (A[i] != target) {
				break;
			}
			rst[0] = i;
		}
		for (int i = index; i < A.length; i++) {
			if (A[i] != target) {
				break;
			}
			rst[1] = i;
		}
		return rst;
	}
	private int binarySearch(int[] A, int start, int end, int target) {
		if (start == end && A[start] != target) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (target == A[mid]) {
			return mid;
		} else if (target > A[mid]) {
			return binarySearch(A, mid+1, end, target);
		} else {
			return binarySearch(A, start, mid, target);
		}
	}
}