/*
Given n non-negative integers a1, a2, ..., an, 
where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
*/

public class Solution {
	public int maxArea(int[] height) {
		int area = 0;
		int start = 0, end = height.length - 1;
		while (start < end) {
			int tmp = Math.min(height[start], height[end]) * (end - start + 1);
			area = Math.max(area, tmp);
			if (height[start] > height[end])
				end--;
			else
				start++;
		}
		return area;
	}
}