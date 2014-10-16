/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		int rst = 0;
		int gap = Integer.MAX_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < num.length-2; i++) {
			int m = i + 1, n = num.length - 1;
			while (m < n) {
				int sum = num[i] + num[m] + num[n];
				int sub = Math.abs(sum - target);
				if (gap > sub) {
					rst = sum;
					gap = sub;
				}
				if (sum < target)
					m++;
				else
					n--;
			}
		}
		return rst;
	}
}