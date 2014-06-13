/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> rst = new ArrayList<String>();
		if (n > 0) {
			generateParenthesis(rst, "", n, n);
		}
		return rst;
	}
	private void generateParenthesis(List<String> rst, String tmp, int left, int right) {
		if (left == 0 && right == 0) {
			rst.add(tmp);
			return ;
		}
		if (left > 0) {
			generateParenthesis(rst, tmp+"(", left-1, right);
		}
		if (right > left) {
			generateParenthesis(rst, tmp+")", left, right-1);
		}
	}
}