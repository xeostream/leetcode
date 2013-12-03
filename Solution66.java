import java.util.Stack;

/*
 * Evaluate Reverse Polish Notation
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution66 {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) return 0;
		Stack<String> stack = new Stack<String>();
		for (String str : tokens) {
			char c = str.charAt(0);
			if (c >= '*' && c <= '/' && str.length() == 1) {
				int i = Integer.parseInt(stack.pop());
				int j = Integer.parseInt(stack.pop());
				switch(c) {
				case '+':
					stack.push(i+j+"");
					break;
				case '*':
					stack.push(i*j+"");
					break;
				case '-':
					stack.push(j-i+"");
					break;
				case '/':
					stack.push(j/i+"");
					break;
				}
			} else
				stack.push(str);
		}
		return Integer.parseInt(stack.pop());
	}
}
