public class Solution83 {
	public int largestRectangleArea(int[] height) {
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || stack.peek() < height[i]) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int length = stack.isEmpty() ? i : (i - stack.peek() - 1);
				area = Math.max(area, height[start]*length);
				i--;
			}
		}
		while (!stack.isEmpty()) {
			int start = stack.pop();
			int length = stack.isEmpty() ? height.length : (height - stack.peek() - 1);
			area = Math.max(area, height[start]*length);
		}
		return area;
	}
}