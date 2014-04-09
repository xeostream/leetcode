public class Solution83 {
	public int largestRectangleArea(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length; i++) {
        	if (height[max] < height[i]) {
        		max = i;
        	}
        }
        int[] maxArea = new int[1];
        largestRectangleArea(height, max-1, max, height[max], maxArea);
        largestRectangleArea(height, max, max+1, height[max], maxArea);
        return maxArea[0];
    }

    public void largestRectangleArea(int[] height, int begin, int end, int currentHeight, int[] maxArea) {
    	if (begin < 0 || end >= height.length) return ;
    	int min = Math.min(height[begin], height[end]);
    	min = Math.min(min, currentHeight);
    	maxArea[0] = Math.max(maxArea[0], min*(end-begin+1));
    	largestRectangleArea(height, begin-1, end, min, maxArea);
    	largestRectangleArea(height, begin, end+1, min, maxArea);
    }
}