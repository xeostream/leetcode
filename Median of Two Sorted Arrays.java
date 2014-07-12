/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int total = A.length + B.length;
		if ((total & 0x1) == 1) {
			return findKth(A, 0, B, 0, total / 2 + 1);
		} else {
			return (findKth(A, 0, B, 0, total / 2) + findKth(A, 0, B, 0, total / 2 + 1)) / 2.0;
		}
	}
	private double findKth(int A[], int aStart, int B[], int bStart, int k) {
		int aLen = A.length - aStart, bLen = B.length - bStart;
		if (aLen > bLen) return findKth(B, bStart, A, aStart, k);
		if (aLen == 0) return B[bStart + k - 1];
		if (k == 1) return Math.min(A[aStart], B[bStart]);
		int ia = Math.min(k / 2, aLen), ib = k - ia;
		if (A[aStart + ia - 1] < B[bStart + ib - 1]) {
			return findKth(A, aStart + ia, B, bStart, k - ia);
		} else if (A[aStart + ia - 1] > B[bStart + ib - 1]) {
			return findKth(A, aStart, B, bStart + ib, k - ib);
		} else {
			return A[aStart + ia - 1];
		}
	}
}