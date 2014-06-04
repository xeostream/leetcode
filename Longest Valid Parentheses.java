/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
	// stack
	public int longestValidParentheses(String s) {
		int rst = 0, last = -1;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						rst = Math.max(rst, i-last);
					} else {
						rst = Math.max(rst, i-stack.peek());
					}
				}
			}
		}
		return rst;
	}
	// Dynamic Programming, One Pass
	public int longestValidParentheses(String s) {
		int rst = 0;
		int[] rec = new int[s.length()];
		for (int i = s.length()-2; i >= 0; i--) {
			int match = i + 1 + rec[i+1];
			if (s.charAt(i) == '(' && match < s.length() && s.charAt(match) == ')') {
				rec[i] = rec[i+1] + 2;
				if (match + 1 < s.length()) {
					rec[i] += rec[match+1];
				}
				rst = Math.max(rst, rec[i]);
			}
		}
		return rst;
	}
}