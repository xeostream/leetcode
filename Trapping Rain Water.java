/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
how much water it is able to trap after raining.
For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
	public int trap(int[] A) {
		if (A.length < 3) return 0;
		int[] water = new int[A.length];
		int[] start = indexOfMax(A);
		for (int i = 2; i < A.length; i++) {
			if (A[i] <= A[i-1]) {
				water[i] = water[i-1];
			} else {
				int end = i;
				int add = 0;
				int min = Math.min(A[start], A[end]);
				for (int j = start[i]+1; j < end; j++) {
					add += (A[j] > min ? min : A[j]);
				}
				int w = min * (end-start-1) - add;
				add = 0;
				water[i] = w > 0 ? w+water[start[i]] : water[i-1];
			}
		}
		return water[A.length-1];
	}
	private int[] indexOfMax(int[] A) {
		int[] max = new int[A.length];
		for (int i = 2; i < A.length; i++) {
			if (A[max[i-1]] > A[i-1]) {
				max[i] = max[i-1];
			} else {
				max[i] = i-1;
			}
		}
		return max;
	}
	//better Solution
	public int trap(int[] A) {
		int max = 0;
		int water = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[max]) {
				max = i;
			}
		}
		int peek = 0;
		for (int i = 0; i < max; i++) {
			if (A[i] > peek) {
				peek = A[i];
			} else {
				water += (peek - A[i]);
			}
		}
		int top = 0;
		for (int i = A.length-1; i > max; i--) {
			if (A[i] > top) {
				top = A[i];
			} else {
				water += (top - A[i]);
			}
		}
		return water;
	}
}