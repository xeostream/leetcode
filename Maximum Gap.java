/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space.
Return 0 if the array contains less than 2 elements.
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class Solution {
	public int maximumGap(int[] num) {
		if (null == num || num.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = num.length;
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        double dist = (double)(max - min) / (double)(n - 1);
        int[] minDist = new int[n - 1], maxDist = new int[n - 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(maxDist, Integer.MIN_VALUE);
        for (int i : num) {
            if (i == min || i == max) {
                continue;
            }
            int idx = (int) ((i - min) / dist);
            minDist[idx] = Math.min(i, minDist[idx]);
            maxDist[idx] = Math.max(i, maxDist[idx]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < n - 1; i++) {
            if (minDist[i] == Integer.MAX_VALUE && maxDist[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, minDist[i] - previous);
            previous = maxDist[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
	}
}